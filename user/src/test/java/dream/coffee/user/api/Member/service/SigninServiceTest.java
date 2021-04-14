package dream.coffee.user.api.Member.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional(readOnly = true)
@DisplayName("LoginService Unit Test")
class SigninServiceTest {
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