package dream.coffee.user.api.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class LivenessController {
	Environment env;

	@Autowired
	public LivenessController(Environment env){
		this.env = env; // 환경설정은 필드주입보다, 생성자 주입을 권고하고 있다.
	}

	@GetMapping("/live")
	public String liveness(){
		return "user service alive";
	}

	@GetMapping("/message")
	public String message(@RequestHeader("user-request") String header){
		log.info(header);
		return "Hello World In User Service";
	}

	@GetMapping("/check")
	public String check(HttpServletRequest request){
		log.info("Server port={}", request.getServerPort());
		return String.format("Quak Quak! User Service on Random Port = %s"
				,env.getProperty("local.server.port"));
	}
}
