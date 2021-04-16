package dream.coffee.user.api.Member.service;

import dream.coffee.user.api.Member.repository.MemberRepository;
import dream.coffee.user.UserApplicationTests;
import dream.coffee.user.api.model.dto.MemberInfoChangeReqDto;
import dream.coffee.user.api.model.dto.MemberInfoDto;
import dream.coffee.user.api.model.dto.SignUpReqDto;
import dream.coffee.user.api.model.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@Transactional(readOnly = true)
@DisplayName("MemberService Unit Test")
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
					() -> {memberService.SignUp(alreadyExistMember);}
				)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("이미 존재하는 아이디 입니다.");
		// than

	}

	@Test
	@DisplayName("GREEN 회원 정보조회")
	public void 회원_정보조회_성공(){
		// given
		String alreadyExistMemberId = "alreadyExist";
		// when
		MemberInfoDto aMemberInfo = memberService.aMemberInfo(alreadyExistMemberId);
		// than
		assertThat(aMemberInfo)
				.isNotNull()
				.extracting("id","name", "email")
				.contains(
						"alreadyExist", "test", "test@email.com"
				)
				;

	}

	@Test
	@DisplayName("RED 회원 정보실패")
	public void 회원_정보조회_실패(){
		// given
		String doesntExistMemberId = "notExist";
		// when
		// than
		assertThatThrownBy(
				() -> {memberService.aMemberInfo(doesntExistMemberId);}
		)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("존재하지 않은 아이디 입니다.");
	}

	@Transactional
	@Rollback(value = true)
	@Test
	@DisplayName("GREEN 회원정보 변경 :: 이름 변경")
	public void 회원_정보_이름_변경(){
		// given
		String fixture = "changeName";
		MemberInfoChangeReqDto changeNameReq = MemberInfoChangeReqDto
			.builder()
				.id("alreadyExist")
				.name(fixture)
				.isUseMarketing(true)
			.build();
		// when
		MemberInfoDto changedMemberInfo = memberService.changeAMemberInfo(changeNameReq);
		// than
		assertThat(changedMemberInfo.getName())
				.isNotNull()
				.as("Check Changed Name = %s ", changedMemberInfo.getName())
				.isEqualTo(fixture);
	}

	@Transactional
	@Rollback(value = true)
	@Test
	@DisplayName("GREEN 회원정보 변경 :: 이메일 변경")
	public void 회원_정보_이메일_변경(){
		// given
		String fixture = "change@email.com";
		MemberInfoChangeReqDto changeEmailReq = MemberInfoChangeReqDto
			.builder()
				.id("alreadyExist")
				.email(fixture)
				.isUseMarketing(true)
			.build();

		// when
		MemberInfoDto changedMemberInfo = memberService.changeAMemberInfo(changeEmailReq);
		// than
		assertThat(changedMemberInfo.getEmail())
				.isNotNull()
				.as("Check Changed Email = %s ", changedMemberInfo.getEmail())
				.isEqualTo(fixture);
	}

	@Transactional
	@Rollback(value = true)
	@Test
	@DisplayName("GREEN 회원정보 변경 :: 마케팅수신여부")
	public void 회원_정보_마케팅수신여_변경(){
		// given
		MemberInfoChangeReqDto changeUseMarketingReq = MemberInfoChangeReqDto
			.builder()
				.id("alreadyExist")
				.isUseMarketing(false) //true -> false
			.build();
		// when
		MemberInfoDto changedMemberInfo = memberService.changeAMemberInfo(changeUseMarketingReq);
		// than
		assertThat(changedMemberInfo.isUseMarketing())
				.isNotNull()
				.as("Check Changed isUseMarketing = %s ", changedMemberInfo.isUseMarketing())
				.isEqualTo(false);
	}

	@Test
	@DisplayName("RED 회원정보 변경 :: 마케팅수신여부, 이름 변경, 이메일 변경 실패")
	public void 회원_정보_변경_실패(){
		// given
		// when
		// than
	}

	@Test
	public void 회원_비밀번호_변경(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("GREEN 회원정보 인증 성공")
	public void 회원_인증하기(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("RED 회원정보 인증 실패")
	public void 회원_인증하기_실패(){
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
}