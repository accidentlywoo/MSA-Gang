package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.PaymentMethod;
import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Payment extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long id;

	@OneToOne(mappedBy = "payment")
	private Order order;

	@Enumerated
	private PaymentMethod method;

	private int amountOfPayment;

	private boolean approval;

	protected Payment() { }

	private Payment(PaymentMethod method, int amountOfPayment) {
		this.method = method;
		this.amountOfPayment = amountOfPayment;
		this.approval = false;
	}

	public static Payment createPayment(PaymentMethod method, int amountOfPayment){
		return new Payment(method, amountOfPayment);
	}

	protected void setOrderInfo(Order aOrder){
		this.order = aOrder;
	}

	public Payment approve(){
		this.approval = true;

		return this;
	}
}
