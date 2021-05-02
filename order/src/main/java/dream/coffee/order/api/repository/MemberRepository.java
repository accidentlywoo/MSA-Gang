package dream.coffee.order.api.repository;

import dream.coffee.order.api.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByMemberId(String memberId);

	@Deprecated
	<S extends Member> S saveAndFlush(S entity);

	@Deprecated
	<S extends Member> List<S> saveAll(Iterable<S> entities);

	@Deprecated
	void deleteInBatch(Iterable<Member> entities);

	@Deprecated
	void deleteAllInBatch();

	@Deprecated
	<S extends Member> S save(S entity);

	@Deprecated
	void deleteById(Long aLong);

	@Deprecated
	void delete(Member entity);

	@Deprecated
	void deleteAll(Iterable<? extends Member> entities);

	@Deprecated
	void deleteAll();
}
