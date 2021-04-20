package dream.coffee.orderProcess.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order_process")
public class LivenessController {
	@GetMapping("/live")
	public String liveness(){
		return "order process service alive";
	}

	@GetMapping("/message")
	public String message(@RequestHeader("order-process-request") String header){
		log.info(header);
		return "Hello World In User Service";
	}

	@GetMapping("/check")
	public String check(){
		return "MQ MQ!";
	}
}
