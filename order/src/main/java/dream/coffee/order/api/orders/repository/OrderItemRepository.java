package dream.coffee.order.api.orders.repository;

import dream.coffee.order.api.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
