package dream.coffee.order.api.repository;

import dream.coffee.order.api.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findProductByCode(String code);
}
