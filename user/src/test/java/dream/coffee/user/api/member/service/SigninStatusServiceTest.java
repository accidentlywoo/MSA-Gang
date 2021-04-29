package dream.coffee.user.api.member.service;

import com.netflix.discovery.converters.Auto;
import dream.coffee.user.UserApplicationTests;
import dream.coffee.user.api.member.dto.SignUpReqDto;
import dream.coffee.user.api.model.entity.Member;
import dream.coffee.user.api.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional(readOnly = true)
@DisplayName("LoginService Unit Test")
class SigninStatusServiceTest extends UserApplicationTests {

	@Autowired private SignStatusService signStatusService;
	@Autowired private MemberRepository memberRepository;

	@Transactional
	@Rollback(value = true)
	@Test
	@DisplayName("GREEN 회원가입")
	public void 회원_가입_성공(){
		// given
		SignUpReqDto newMember = SignUpReqDto.builder()
				.id("test")
				.pwd("test")
				.name("test")
				.email("test")
				.isCertifivation(true)
				.isUseMarketing(true)
				.build();
		// when
		Long newMemberId = signStatusService.signUp(newMember);

		// than
		Optional<Member> findAMember = memberRepository.findById(newMemberId);

		assertNotNull(findAMember.get());

		assertThat(findAMember.get().getMemberId()).isEqualTo("test");

		assertThat(newMemberId).isEqualByComparingTo(findAMember.get().getId());
	}

	@Transactional
	@Rollback(value = true)
	@Test
	@DisplayName("RED 회원가입")
	public void 회원_가입_중복아이디(){
		// given
		SignUpReqDto alreadyExistMember = SignUpReqDto.builder()
				.id("alreadyExist")
				.pwd("alreadyExist")
				.name("test")
				.email("test@email.com")
				.isCertifivation(true)
				.isUseMarketing(true)
				.build();
		// when
		assertThatThrownBy(
				() -> {signStatusService.signUp(alreadyExistMember);}
		)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("이미 존재하는 아이디 입니다.");
		// than

	}
	@Test
	@DisplayName("GREEN 로그인")
	public void 로그인_성공(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("RED 로그인")
	public void 로그인_잘못된비밀번호(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("RED 로그인")
	public void 로그인_비활성화사용자(){
		// given
		// when
		// than
	}

}