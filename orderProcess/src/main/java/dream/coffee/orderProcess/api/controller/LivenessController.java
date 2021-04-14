package dream.coffee.orderProcess.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_process")
public class LivenessController {
	@GetMapping("/live")
	public String liveness(){
		return "order process service alive";
	}
}
