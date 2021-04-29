package dream.coffee.user.api.member.controller;

import dream.coffee.user.api.member.dto.InfoChangeReqDto;
import dream.coffee.user.api.member.dto.InfoDto;
import dream.coffee.user.api.member.service.InfomationService;
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
@Description("대고객 서비스. 한명의 클라이언트 정보 도메인.")
@RequiredArgsConstructor
@RestController
public class MemberInfoController {
	private final InfomationService infomationService;

	@GetMapping("/{id}")
	public ResponseEntity<InfoDto> getAMemberInfo(@PathVariable("id") @NotBlank @Size(min = 5, max = 20) String id){
		return ResponseEntity.status(HttpStatus.OK).body(infomationService.getAMemberInfo(id));
	}

	@PostMapping("/")
	public ResponseEntity<InfoDto> changeAMemberInfo(@Valid @RequestBody InfoChangeReqDto reqDto){
		return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(infomationService.changeAMemberInfo(reqDto));
	}

}
