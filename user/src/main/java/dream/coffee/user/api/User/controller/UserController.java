package dream.coffee.user.api.User.controller;

import dream.coffee.user.api.model.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

	@GetMapping("/")
	public List<MemberInfoDto> viewAllUsers(){
		return null;
	}
}
