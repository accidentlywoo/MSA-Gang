package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired private MemberRepository memberRepository;

	@Test
	public void testEntityManager(){
		assertNotNull(entityManager);
	}

	@Test
	public void 멤버_저장_테스트(){
		memberRepository.save(Member.createMember("test","test", "1", "test@email", true, true));
		// when
		Optional<Member> byId = memberRepository.findByMemberId("test");
		// than
		assertEquals("test", byId.get().getMemberId());
	}

	@Test
	public void 조회_테스트(){
		memberRepository.save(Member.createMember("test","test", "1", "test@email", true, true));
		// when
		List<Member> all = memberRepository.findAll();

		Optional<Member> findById = memberRepository.findByMemberId("test");
		// than
		assertEquals(2, all.size());
		assertNotNull(findById);
		assertThat(all).hasSize(2).extracting("memberId").contains("test");
	}


	@Test
	@Transactional
	public void 멤버_휴먼처리(){
		memberRepository.save(Member.createMember("test","test", "1", "test@email", true, true));
	    // given
		Optional<Member> byId = memberRepository.findByMemberId("test");
		// when
		byId.get().changeDormantMember(true);
		memberRepository.save(byId.get());
	    // than
		assertTrue(byId.get().isDormant());
	}

	@Test
	@Transactional
	public void 멤버_휴먼처리_해제(){
		memberRepository.save(Member.createMember("test","test", "1", "test@email", true, true));
		// given
		Optional<Member> byId = memberRepository.findByMemberId("test");
		// when
		byId.get().changeDormantMember(false);
		memberRepository.save(byId.get());
		// than
		assertFalse(byId.get().isDormant());
	}
}