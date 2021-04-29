package dream.coffee.user.api.member.controller;

import dream.coffee.user.api.member.dto.OrderDto;
import dream.coffee.user.api.member.service.OrderViewer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/member")
@Description("대고객 서비스. 한명의 클라이언트에대한 주문정보 조회 도메인.")
@RequiredArgsConstructor
@RestController
public class OrderViewController {
	private final OrderViewer orderViewer;

	@GetMapping("/orders")
	public ResponseEntity<List<OrderDto>> findOrders(){
		return ResponseEntity.status(HttpStatus.OK).body(orderViewer.getOrderList());
	}

	@GetMapping("/orders/{order-code}")
	public ResponseEntity<OrderDto> findAOrder(@PathVariable(name = "order-code")String orderCode){
		return ResponseEntity.status(HttpStatus.OK).body(orderViewer.getAOrder(orderCode));
	}
}
