package dream.coffee.user.api.User.repository;

import dream.coffee.user.api.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	@Deprecated
	<S extends OrderItem> List<S> saveAll(Iterable<S> entities);

	@Deprecated
	<S extends OrderItem> S saveAndFlush(S entity);

	@Deprecated
	void deleteInBatch(Iterable<OrderItem> entities);

	@Deprecated
	void deleteAllInBatch();

	@Deprecated
	<S extends OrderItem> S save(S entity);

	@Deprecated
	void deleteById(Long aLong);

	@Deprecated
	void delete(OrderItem entity);

	@Deprecated
	void deleteAll(Iterable<? extends OrderItem> entities);

	@Deprecated
	void deleteAll();
}
