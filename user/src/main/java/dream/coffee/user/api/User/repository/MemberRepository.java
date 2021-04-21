package dream.coffee.user.api.User.repository;

import dream.coffee.user.api.model.entity.Member;
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


}
