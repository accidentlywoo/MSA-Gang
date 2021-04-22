package dream.coffee.user.api.User.controller;

import dream.coffee.user.api.Member.model.dto.MemberInfoChangeReqDto;
import dream.coffee.user.api.User.model.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/user")
@Description("관리자 서비스. 사용자 정보 도메인.")
@RequiredArgsConstructor
@RestController
public class UserController {

	@GetMapping("/")
	public List<MemberInfoDto> viewAllUsers(){
		return null;
	}

	@PostMapping("/")
	public List<MemberInfoDto> changeAUser(@Valid @RequestBody List<MemberInfoChangeReqDto> reqDtos){
		return null;
	}

	@GetMapping("/{member_id}")
	public MemberInfoDto viewAUser(@PathVariable(name = "member_id")String member_id){
		return null;
	}

}
