package dream.coffee.order.api.repository;

import dream.coffee.order.api.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
