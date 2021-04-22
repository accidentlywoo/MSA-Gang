package dream.coffee.user.api.controller;

import dream.coffee.user.configuration.Greeting;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class LivenessController {
	final Environment env;

	private final Greeting greeting;

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

	@GetMapping("/welcome")
	public String welcome(){
//		return env.getProperty("greeting.message");
		return greeting.getMessage();
	}
}
