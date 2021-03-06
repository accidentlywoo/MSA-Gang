package dream.coffee.order.api.repository;

import dream.coffee.order.api.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
