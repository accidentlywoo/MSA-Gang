package dream.coffee.user.api.Member.service;

import dream.coffee.user.api.Member.repository.MemberRepository;
import dream.coffee.user.UserApplicationTests;
import dream.coffee.user.api.model.dto.SignUpReqDto;
import dream.coffee.user.api.model.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional(readOnly = true)
@DisplayName("MemberService TDD")
class MemberServiceTest extends UserApplicationTests {

	@Autowired private MemberService memberService;

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
		Long newMemberId = memberService.SignUp(newMember);
		Optional<Member> findAMember = memberRepository.findById(newMemberId);
		// than
		assertEquals(findAMember.get().getId(),newMemberId);
	}

	@Test
	@DisplayName("RED 회원가입")
	public void 회원_가입_중복아이디(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("GREEN 회원 정보조회")
	public void 회원_정보조회_성공(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("GREEN 회원 정보실패")
	public void 회원_정보조회_실패(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("GREEN 회원정보 변경 :: 마케팅수신여부")
	public void 회원_마케팅수신여부_변경(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("RED 회원정보 변경 :: 마케팅수신여부 실패")
	public void 회원_마케팅수신여부_변경_실패(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("GREEN 회원 활성화여부 :: 탈퇴 성공")
	public void 회원_활성화여부_변경(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("RED 회원 활성화여부 실패 :: 탈퇴 실패")
	public void 회원_활성화여부_변경_실패(){
		// given
		// when
		// than
	}

	// TODO -- 로그인 구분해야될 듯
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