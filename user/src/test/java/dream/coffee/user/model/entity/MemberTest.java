package dream.coffee.user.model.entity;

import dream.coffee.user.Member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
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

	private static Member newMember;

	@Test
	public void testEntityManager(){
		assertNotNull(entityManager);
	}

	@BeforeAll
	public static void Setting_Save(){
		newMember = Member.createMember("test","test", "1", "test@email", true, true);

	}

	@Test
	public void 멤버_저장_테스트(){
		memberRepository.save(newMember);
		// when
		Optional<Member> byId = memberRepository.findById(newMember.getId());
		// than
		assertEquals("test", byId.get().getMemberId());
	}

	@Test
	public void 조회_테스트(){
		memberRepository.save(newMember);
		// when
		List<Member> all = memberRepository.findAll();

		Optional<Member> findById = memberRepository.findByMemberId("test");
		// than
		assertEquals(1, all.size());
		assertNotNull(findById);
		assertThat(all).hasSize(1).contains(findById.get());
	}


	@Test
	@Transactional
	public void 멤버_휴먼처리(){
		memberRepository.save(newMember);
		entityManager.persist(newMember);
	    // given
		Optional<Member> byId = memberRepository.findByMemberId(newMember.getMemberId());
		// when
		byId.get().changeDormantMember(true);
		memberRepository.save(byId.get());
	    // than
		assertTrue(byId.get().isDormant());
	}

	@Test
	@Transactional
	public void 멤버_휴먼처리_해제(){
		memberRepository.save(newMember);
		// given
		Optional<Member> byId = memberRepository.findByMemberId(newMember.getMemberId());
		// when
		byId.get().changeDormantMember(false);
		memberRepository.save(byId.get());
		// than
		assertFalse(byId.get().isDormant());
	}
}