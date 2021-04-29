package dream.coffee.user.api.member.controller;

import dream.coffee.user.api.member.dto.InfoDto;
import dream.coffee.user.api.member.dto.SignInReqDto;
import dream.coffee.user.api.member.dto.SignUpReqDto;
import dream.coffee.user.api.member.service.InfomationService;
import dream.coffee.user.api.member.service.SignStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Slf4j
@RequestMapping("/member")
@Description("대고객 서비스. 한명의 클라이언트 (사인인)상태 도메인.")
@RequiredArgsConstructor
@RestController
public class SignStatusController {
	private final SignStatusService signStatusService;

	/**
	 * 회원가입 컨트롤러
	 *  성공 : 201 status code (데이터 생성)
	 *
	 * @param reqDto
	 * @return
	 */
	@PostMapping("/sign-up")
	public ResponseEntity<Long> signUp(@Valid @RequestBody SignUpReqDto reqDto){
		return new ResponseEntity<Long>(signStatusService.signUp(reqDto), HttpStatus.CREATED);
	}

	@PostMapping("/sign-in")
	public ResponseEntity<InfoDto> signIn(@Valid @RequestBody SignInReqDto reqDto){
		return ResponseEntity.status(HttpStatus.OK).body(signStatusService.signIn(reqDto));
	}

	@PostMapping("/sign-out/{id}")
	public ResponseEntity<Void> signOut(@PathVariable("id") @NotBlank @Size(min = 5, max = 20) String id){
		signStatusService.signOut(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
