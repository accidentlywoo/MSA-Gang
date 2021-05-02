package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.PaymentMethod;
import dream.coffee.order.api.repository.PaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DisplayName("╯°□°）╯ 결제 정보 조회, 생성 , 변경 엔터튀 테스트!")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PaymentTest {
	@Autowired
	private PaymentRepository paymentRepository;

	@Test
	@DisplayName("GREEN 주문 아이템 정보생성")
	public void 결제정보_생성_GREEN(){
	    // given
		결제정보_생성_픽스처();
	}

	@Test
	@DisplayName("결제정보 승인 처리")
	public void 결제정보_승인처리(){
		// given
		final Payment payment = 결제정보_생성_픽스처();

		assertThat(payment.isApproval())
				.isFalse();

		// when
		paymentRepository.save(payment.approve());

		final Optional<Payment> after = paymentRepository.findById(payment.getId());

		// than
		assertThat(after).isNotEmpty();

		assertThat(after.get())
				.extracting("method", "amountOfPayment", "approval")
				.contains(payment.getMethod(), payment.getAmountOfPayment(), true);

	}

	private Payment 결제정보_생성_픽스처(){
		PaymentMethod testMethod = PaymentMethod.BIT_COIN;
		int testAmount = 10000;

		final Payment payment = Payment.createPayment(testMethod, testAmount);

		paymentRepository.save(payment);

		final Optional<Payment> after = paymentRepository.findById(payment.getId());

		assertThat(after).isNotEmpty();

		assertThat(after.get())
				.extracting("method", "amountOfPayment", "approval")
				.contains(testMethod, testAmount, false);

		return after.get();
	}
}