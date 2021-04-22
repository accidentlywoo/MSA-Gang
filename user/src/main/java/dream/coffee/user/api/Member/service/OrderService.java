package dream.coffee.user.api.Member.service;

import dream.coffee.user.api.Member.repository.OrderItemRepository;
import dream.coffee.user.api.Member.repository.ProductRepository;
import dream.coffee.user.api.Member.repository.OrderRepository;
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
