package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String orderCode;

	private int totalPrice;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "id")
	private Payment payment;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	@Embedded
	private BaseEntity baseEntity;

	protected Order(){}
}
