package dream.coffee.user.api.model.entity;


import dream.coffee.user.api.model.entity.baseEntity.BaseEntity;

import javax.persistence.*;

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
}
