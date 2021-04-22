package dream.coffee.user.api.repository;

import dream.coffee.user.api.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
	@Deprecated
	<S extends Order> List<S> saveAll(Iterable<S> entities);

	@Deprecated
	<S extends Order> S saveAndFlush(S entity);

	@Deprecated
	void deleteInBatch(Iterable<Order> entities);

	@Deprecated
	void deleteAllInBatch();

	@Deprecated
	<S extends Order> S save(S entity);

	@Deprecated
	void deleteById(Long aLong);

	@Deprecated
	void delete(Order entity);

	@Deprecated
	void deleteAll(Iterable<? extends Order> entities);

	@Deprecated
	void deleteAll();
}
