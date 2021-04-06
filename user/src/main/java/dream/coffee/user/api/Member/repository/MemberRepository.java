package dream.coffee.user.api.Member.repository;

import dream.coffee.user.api.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByMemberId(String memberId);
}
