package dream.coffee.user.api.Member.controller;

import dream.coffee.user.api.Member.model.dto.MemberInfoDto;
import dream.coffee.user.api.Member.model.dto.SignUpReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RequestMapping("/member")
@Description("대고객 서비스. 한명의 클라이언트 정보 도메인.")
@RequiredArgsConstructor
@RestController
public class MemberController {

	@GetMapping("/{member_id}")
	public MemberInfoDto getAMemberInfo(@PathVariable(name = "member_id")String member_id){
		return null;
	}

	@PostMapping("/{member_id}")
	public MemberInfoDto changeAMemberInfo(@PathVariable(name = "member_id")String member_id){
		return null;
	}

}
