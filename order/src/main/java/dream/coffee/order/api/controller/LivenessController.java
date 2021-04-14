package dream.coffee.order.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class LivenessController {
	@GetMapping("/live")
	public String liveness(){
		return "order service alive";
	}
}
