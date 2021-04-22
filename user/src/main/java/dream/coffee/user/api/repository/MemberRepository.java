package dream.coffee.user.api.repository;

import dream.coffee.user.api.model.entity.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByMemberId(String memberId);

	@Deprecated
	void deleteInBatch(Iterable<Member> entities);

	@Deprecated
	void deleteAllInBatch();

	@Deprecated
	void deleteById(Long aLong);

	@Deprecated
	void delete(Member entity);

	@Deprecated
	void deleteAll(Iterable<? extends Member> entities);

	@Deprecated
	void deleteAll();

	@Deprecated
	List<Member> findAll();

	@Deprecated
	List<Member> findAll(Sort sort);

	@Deprecated
	<S extends Member> List<S> findAll(Example<S> example);

	@Deprecated
	<S extends Member> List<S> findAll(Example<S> example, Sort sort);

	@Deprecated
	Page<Member> findAll(Pageable pageable);

	@Deprecated
	<S extends Member> Page<S> findAll(Example<S> example, Pageable pageable);

	@Deprecated
	<S extends Member> long count(Example<S> example);
}
