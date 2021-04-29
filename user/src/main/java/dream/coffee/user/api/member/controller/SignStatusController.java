package dream.coffee.user.api.member.controller;

import dream.coffee.user.api.member.dto.InfoDto;
import dream.coffee.user.api.member.dto.SignInReqDto;
import dream.coffee.user.api.member.dto.SignUpReqDto;
import dream.coffee.user.api.member.service.InfomationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/member")
@Description("대고객 서비스. 한명의 클라이언트 (사인인)상태 도메인.")
@RequiredArgsConstructor
@RestController
public class SignStatusController {
	private final InfomationService memberService;

	/**
	 * 회원가입 컨트롤러
	 *  성공 : 201 status code (데이터 생성)
	 *
	 * @param reqDto
	 * @return
	 */
	@PostMapping("/signUp")
	public ResponseEntity<Long> signUp(@Valid @RequestBody SignUpReqDto reqDto){
		return new ResponseEntity<Long>(memberService.SignUp(reqDto), HttpStatus.CREATED);
	}

	@PostMapping("/signIn")
	public InfoDto signIn(@Valid @RequestBody SignInReqDto reqDto){
		return null;
	}

	@PostMapping("/signOut")
	public InfoDto signOut(){
		return null;
	}
}
