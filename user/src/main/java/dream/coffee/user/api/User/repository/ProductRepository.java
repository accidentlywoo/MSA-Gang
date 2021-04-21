package dream.coffee.user.api.User.repository;

import dream.coffee.user.api.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Deprecated
	void deleteInBatch(Iterable<Product> entities);

	@Deprecated
	void deleteAllInBatch();

	@Deprecated
	void deleteById(Long aLong);

	@Deprecated
	void delete(Product entity);

	@Deprecated
	void deleteAll(Iterable<? extends Product> entities);

	@Deprecated
	void deleteAll();
}
