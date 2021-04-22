package dream.coffee.user.api.Member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/member")
@Description("대고객 서비스. 한명의 클라이언트에대한 주문정보 조회 도메인.")
@RequiredArgsConstructor
@RestController
public class OrderController {
	@GetMapping("/orders")
	public Object findOrders(){
		return null;
	}

	@GetMapping("/orders/{order_code}")
	public Object findAOrder(@PathVariable(name = "order_code")String order_code){
		return null;
	}
}
