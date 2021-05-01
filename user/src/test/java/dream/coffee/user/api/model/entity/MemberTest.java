package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberTest {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void 조회_테스트(){
		// given
		final Member member = 멤버_미인증_마케팅사용안함_픽스처();

		final Optional<Member> searchMember = memberRepository.findByMemberId(member.getMemberId());

		assertThat(searchMember).isNotEmpty();

		assertThat(searchMember.get())
				.extracting("memberId", "name", "password", "email")
				.contains(member.getMemberId(), member.getName(), member.getPassword(), member.getEmail());
	}

	@Test
	public void 멤버_휴먼처리(){
		// given
		final Member member = 멤버_미인증_마케팅사용안함_픽스처();

		// when
		member.inActiveMember();

		memberRepository.save(member);

		Optional<Member> afterMember = memberRepository.findByMemberId(member.getMemberId());

		// than
		assertThat(afterMember.get())
				.extracting("memberId", "active")
				.contains(member.getMemberId(), false);
	}

	@Test
	@Transactional
	public void 멤버_휴먼처리_해제(){
		// given
		final Member member = 멤버_미인증_마케팅사용안함_픽스처();

		// when
		member.activeMember();

		memberRepository.save(member);

		Optional<Member> afterMember = memberRepository.findByMemberId(member.getMemberId());

		// than
		assertThat(afterMember.get())
				.extracting("memberId", "active")
				.contains(member.getMemberId(), true);
	}

	@Test
	public void 멤버_인증처리_GREEN(){
	    // given
		final Member member = 멤버_미인증_마케팅사용안함_픽스처();

		assertThat(member.isCertification()).isFalse();

	    // when
		member.certificateMember();

		memberRepository.save(member);

		// than
		assertThat(member.isCertification()).isTrue();
	}

	@Test
	public void 멤버_인증실패_GREEN(){
		// given
		// when
		// than
	}

	@Test
	public void 멤버_이름_수정_GREEN(){
		// given
		// when
		// than
	}

	@Test
	public void 멤버_이름_수정_RED(){
		// given
		// when
		// than
	}

	@Test
	public void 멤버_이메일_수정_GREEN(){
		// given
		// when
		// than
	}

	@Test
	public void 멤버_이메일_수정_RED(){
		// given
		// when
		// than
	}

	@Test
	public void 멤버_마케팅사용_GREEN(){
		// given
		// when
		// than
	}

	@Test
	public void 멤버_마케팅미사용_GREEN(){
		// given
		// when
		// than
	}

	private Member 멤버_미인증_마케팅사용안함_픽스처(){
		String memberId = "test";
		String name = "testName";
		String password = "testPassword";
		String email = "test@email";

		memberRepository.save(Member.createMember(memberId,name, password, email, false, false));
		// when
		Optional<Member> member = memberRepository.findByMemberId("test");
		// than
		assertThat(member).isNotEmpty();

		assertThat(member.get())
				.extracting("memberId", "name", "password", "email", "useMarketing", "certification", "active")
				.contains(memberId, name, password, email, false, false, true);

		return member.get();
	}

	private Member 멤버_인증_마케팅사용함_픽스처(){
		String memberId = "test";
		String name = "testName";
		String password = "testPassword";
		String email = "test@email";

		memberRepository.save(Member.createMember(memberId,name, password, email, true, true));
		// when
		Optional<Member> member = memberRepository.findByMemberId("test");
		// than
		assertThat(member).isNotEmpty();

		assertThat(member.get())
				.extracting("memberId", "name", "password", "email", "useMarketing", "certification", "active")
				.contains(memberId, name, password, email, true, true, true);

		return member.get();
	}
}