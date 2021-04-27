package dream.coffee.user.api.member.service;

import dream.coffee.user.api.repository.OrderItemRepository;
import dream.coffee.user.api.repository.ProductRepository;
import dream.coffee.user.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final ProductRepository productRepository;
}
