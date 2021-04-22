package dream.coffee.order.api.Orders.service;

import dream.coffee.order.api.Orders.repository.OrderItemRepository;
import dream.coffee.order.api.Orders.repository.OrderRepository;
import dream.coffee.order.api.Orders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final ProductRepository productRepository;

	public Object orderProduct(){
		return null;
	}
}
