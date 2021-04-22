package dream.coffee.user.api.Member.controller;

import dream.coffee.user.api.Member.model.dto.MemberInfoDto;
import dream.coffee.user.api.Member.model.dto.SignInReqDto;
import dream.coffee.user.api.Member.model.dto.SignUpReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/member")
@Description("대고객 서비스. 한명의 클라이언트 (사인인)상태 도메인.")
@RequiredArgsConstructor
@RestController
public class MemberStatusController {
	@PostMapping("/signUp")
	public MemberInfoDto signUp(@Valid @RequestBody SignUpReqDto reqDto){
		return null;
	}

	@PostMapping("/signIn")
	public MemberInfoDto signIn(@Valid @RequestBody SignInReqDto reqDto){
		return null;
	}

	@PostMapping("/signOut")
	public MemberInfoDto signOut(){
		return null;
	}
}
