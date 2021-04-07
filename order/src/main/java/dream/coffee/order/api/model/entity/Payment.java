package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long id;

	@OneToOne(mappedBy = "payment")
	private Order order;

	private String paymentMethod;

	private int amountOfPayment;

	// 승인여부
	private boolean isApproval;

	@Embedded
	private BaseEntity baseEntity;

	protected Payment() { }

	private Payment(String paymentMethod, int amountOfPayment, boolean isApproval) {
		this.paymentMethod = paymentMethod;
		this.amountOfPayment = amountOfPayment;
		this.isApproval = isApproval;
	}

	/**
	 * 결제정보 생성
	 *
	 * @param paymentMethod
	 * @param amountOfPayment
	 * @return
	 */
	public static Payment createPayment(String paymentMethod, int amountOfPayment){
		return new Payment(paymentMethod, amountOfPayment, false);
	}
	protected void setOrderInfo(Order aOrder){
		this.order = aOrder;
	}

	/**
	 * 결제 승인 정보 변경
	 *
	 * @param status
	 * @return
	 */
	public Payment changeApprovalStatus(boolean status){
		this.isApproval = true;
		return this;
	}
}
