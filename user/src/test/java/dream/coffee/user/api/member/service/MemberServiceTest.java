package dream.coffee.user.api.member.service;

import dream.coffee.user.api.member.dto.InfoChangeReqDto;
import dream.coffee.user.api.member.dto.InfoDto;
import dream.coffee.user.api.member.dto.SignUpReqDto;
import dream.coffee.user.api.repository.MemberRepository;
import dream.coffee.user.UserApplicationTests;
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
@DisplayName("InfomationService Unit Test")
class MemberServiceTest extends UserApplicationTests {

	@Autowired private InfomationService memberService;

	@Autowired private MemberRepository memberRepository;



	@Test
	@DisplayName("GREEN 회원 정보조회")
	public void 회원_정보조회_성공(){
		// given
		String alreadyExistMemberId = "alreadyExist";
		// when
		InfoDto aMemberInfo = memberService.aMemberInfo(alreadyExistMemberId);
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
	}

	@Transactional
	@Rollback(value = true)
	@Test
	@DisplayName("GREEN 회원정보 변경 :: 이메일 변경")
	public void 회원_정보_이메일_변경(){
		// given
	}

	@Transactional
	@Rollback(value = true)
	@Test
	@DisplayName("GREEN 회원정보 변경 :: 마케팅수신여부")
	public void 회원_정보_마케팅수신여_변경(){

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