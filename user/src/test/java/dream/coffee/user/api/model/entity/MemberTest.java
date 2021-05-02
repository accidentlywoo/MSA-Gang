package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
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
		final Member member = 멤버_비활성화();

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
		member.certificate();

		memberRepository.save(member);

		// than
		assertThat(member.isCertification()).isTrue();
	}

	@Test
	public void 멤버_이름_수정_GREEN(){
		// given
		String changeName = "changeName";

		final Member member = 멤버_미인증_마케팅사용안함_픽스처();

		final String beaforeName = member.getName();

		assertThat(beaforeName).isNotEqualTo(changeName);

		// when
		memberRepository.save(member.changeName(changeName));

		final Optional<Member> after = memberRepository.findByMemberId(member.getMemberId());

		// than
		assertThat(after).isNotEmpty();

		assertThat(after.get())
				.extracting("name")
				.isEqualTo(changeName);
	}

	@Test
	public void 멤버_이메일_수정_GREEN(){
		// given
		String changeEmail = "change@test.com";

		final Member member = 멤버_미인증_마케팅사용안함_픽스처();

		final String beaforeEmail = member.getEmail();

		assertThat(beaforeEmail).isNotEqualTo(changeEmail);

		// when
		memberRepository.save(member.changeEmail(changeEmail));

		final Optional<Member> after = memberRepository.findByMemberId(member.getMemberId());

		// than
		assertThat(after).isNotEmpty();

		assertThat(after.get())
				.extracting("email")
				.isEqualTo(changeEmail);
	}

	@Test
	public void 멤버_마케팅사용_GREEN(){
		// given
		boolean useMarketing = true;

		final Member member = 멤버_미인증_마케팅사용안함_픽스처();

		assertThat(member.isUseMarketing()).isNotEqualTo(useMarketing);

		// when
		memberRepository.save(member.useMarketing());

		final Optional<Member> after = memberRepository.findByMemberId(member.getMemberId());

		// than
		assertThat(after).isNotEmpty();

		assertThat(after.get())
				.extracting("useMarketing")
				.isEqualTo(useMarketing);
	}

	@Test
	public void 멤버_마케팅미사용_GREEN(){
		// given
		boolean dontUseMarketing = false;

		final Member member = 멤버_인증_마케팅사용함_픽스처();

		assertThat(member.isUseMarketing()).isNotEqualTo(dontUseMarketing);

		// when
		memberRepository.save(member.notUseMarketing());

		final Optional<Member> after = memberRepository.findByMemberId(member.getMemberId());

		// than
		assertThat(after).isNotEmpty();

		assertThat(after.get())
				.extracting("useMarketing")
				.isEqualTo(dontUseMarketing);
	}

	private Member 멤버_비활성화(){
		String memberId = "test";
		String name = "testName";
		String password = "testPassword";
		String email = "test@email";

		memberRepository.save(Member.createMember(memberId,name, password, email, false, false));
		// when
		Optional<Member> member = memberRepository.findByMemberId(memberId);

		assertThat(member).isNotEmpty();

		member.get().inActiveMember();

		memberRepository.save(member.get());

		Optional<Member> inactiveMember =  memberRepository.findByMemberId(memberId);
		// than

		assertThat(inactiveMember.get())
				.extracting("memberId", "name", "password", "email", "useMarketing", "certification", "active")
				.contains(memberId, name, password, email, false, false, false);

		return member.get();
	}

	private Member 멤버_미인증_마케팅사용안함_픽스처(){
		String memberId = "test";
		String name = "testName";
		String password = "testPassword";
		String email = "test@email";

		memberRepository.save(Member.createMember(memberId,name, password, email, false, false));
		// when
		Optional<Member> member = memberRepository.findByMemberId(memberId);
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
		Optional<Member> member = memberRepository.findByMemberId(memberId);
		// than
		assertThat(member).isNotEmpty();

		assertThat(member.get())
				.extracting("memberId", "name", "password", "email", "useMarketing", "certification", "active")
				.contains(memberId, name, password, email, true, true, true);

		return member.get();
	}
}