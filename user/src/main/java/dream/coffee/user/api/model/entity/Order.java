package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.model.OrderStatus;
import dream.coffee.user.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * Read Only
 */
@Getter
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;

	private String orderCode;

	private int totalPrice;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "payment_id")
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
