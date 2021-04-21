package dream.coffee.user.api.Member.controller;

import dream.coffee.user.api.model.dto.MemberInfoDto;
import dream.coffee.user.api.model.dto.SignUpReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RequestMapping("/member")
@Description("대고객 서비스. 한명의 클라이언트에대한 도메인.")
@RequiredArgsConstructor
@RestController
public class MemberController {

	@PostMapping("/")
	public MemberInfoDto signUp(@Valid @RequestBody SignUpReqDto reqDto){
		return null;
	}

	@GetMapping("/{member_id}")
	public MemberInfoDto getAMemberInfo(@PathVariable(name = "member_id")String member_id){
		return null;
	}

	@PostMapping("/{member_id}")
	public MemberInfoDto changeAMemberInfo(@PathVariable(name = "member_id")String member_id){
		return null;
	}

	@PostMapping("/signOut/{member_id}")
	public MemberInfoDto signOut(@PathVariable(name = "member_id")String member_id){
		return null;
	}

}
