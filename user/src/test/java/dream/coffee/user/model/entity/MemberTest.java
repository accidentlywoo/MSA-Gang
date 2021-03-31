package dream.coffee.user.model.entity;

import dream.coffee.user.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("local")
@DataJpaTest
class MemberTest {

	@Autowired private MemberRepository memberRepository;


	@BeforeEach
	@Transactional
	@Rollback(false)
	public void 회원가입(){
	    // given
		Member newMember = Member.createMember("test","test", "1", "test@email", true, true);
		// when
		memberRepository.save(newMember);

		Optional<Member> byId = memberRepository.findById(newMember.getId());
		// than
		assertEquals("test", byId.get().getMemberId());
	}

	@Test
	public void 조회_테스트(){
	    // given
		List<Member> all = memberRepository.findAll();
		// when
		assertEquals(1, all.size());
	    // than
	}
	@Test
	public void 멤버_휴먼처리(){
	    // given
		Optional<Member> byId = memberRepository.findByMemberId("test");
		// when
		byId.get().changeDormantMember(true);
	    // than
		assertTrue(byId.get().isDormant());
	}

	@Test
	public void 멤버_휴먼처리_해제(){
		// given
		Optional<Member> byId = memberRepository.findByMemberId("test");
		// when
		byId.get().changeDormantMember(false);
		// than
		assertFalse(byId.get().isDormant());
	}
}