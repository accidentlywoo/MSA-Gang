package dream.coffee.user.api.model.entity;


import dream.coffee.user.api.model.entity.baseEntity.BaseEntity;

import javax.persistence.*;

@Entity
public class Payment extends BaseEntity{
	@Id
	@Column(name = "payment_id")
	private Long id;

	@OneToOne(mappedBy = "payment")
	private Order order;

	@Column(nullable = false)
	private String method;

	@Column(nullable = false)
	private int amountOfPayment;

	@Column(nullable = false)
	private boolean isApproval;// 승인여부
}
