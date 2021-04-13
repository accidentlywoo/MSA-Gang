package dream.coffee.user.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LivenessController {
	@GetMapping("/live")
	public String liveness(){
		return "user service alive";
	}
}
