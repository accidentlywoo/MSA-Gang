package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.Orders.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("╯°□°）╯ 주문 정보 조회, 생성 , 변경 엔터튀 테스트!")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderTest {

	@Autowired private OrderRepository orderRepository;

	@Test
	@DisplayName("GREEN 주문 정보 생성")
	public void 주문_생성(){
	    // given
	    // when
	    // than
	}

	@Test
	@DisplayName("RED 주문 정보 생성 실패!")
	public void 주문_생성_실패(){
		// given
		// when
		// than
	}
}