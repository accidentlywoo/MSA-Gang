package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.Orders.repository.PaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("╯°□°）╯ 결제 정보 조회, 생성 , 변경 엔터튀 테스트!")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PaymentTest {

	@Autowired private PaymentRepository paymentRepository;

	@Test
	@DisplayName("GREEN 주문 아이템 정보생성")
	public void 결제정보_생성(){
	    // given
	    // when
	    // than
	}

	@Test
	@DisplayName("RED 주문 아이템 정보생성 실패!")
	public void 결제정보_생성_실패(){
		// given
		// when
		// than
	}
}