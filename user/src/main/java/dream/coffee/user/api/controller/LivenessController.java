package dream.coffee.user.api.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class LivenessController {
	@GetMapping("/live")
	public String liveness(){
		return "user service alive";
	}

	@GetMapping("/message")
	public String message(@RequestHeader("user-request") String header){
		log.info(header);
		return "Hello World In User Service";
	}
}
