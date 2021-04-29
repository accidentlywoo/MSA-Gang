package dream.coffee.user.api.member.service;

import dream.coffee.user.api.member.dto.OrderDto;
import dream.coffee.user.api.repository.OrderItemRepository;
import dream.coffee.user.api.repository.ProductRepository;
import dream.coffee.user.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderViewer {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final ProductRepository productRepository;

	public List<OrderDto> getOrderList() {
		return new ArrayList<OrderDto>();
	}

	public OrderDto getAOrder(String orderCode) {
		return null;
	}
}
