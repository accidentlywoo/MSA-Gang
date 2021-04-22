package dream.coffee.user.api.repository;

import dream.coffee.user.api.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	@Deprecated
	<S extends Payment> List<S> saveAll(Iterable<S> entities);

	@Deprecated
	<S extends Payment> S saveAndFlush(S entity);

	@Deprecated
	void deleteInBatch(Iterable<Payment> entities);

	@Deprecated
	void deleteAllInBatch();

	@Deprecated
	<S extends Payment> S save(S entity);

	@Deprecated
	void deleteById(Long aLong);

	@Deprecated
	void delete(Payment entity);

	@Deprecated
	void deleteAll(Iterable<? extends Payment> entities);

	@Deprecated
	void deleteAll();
}
