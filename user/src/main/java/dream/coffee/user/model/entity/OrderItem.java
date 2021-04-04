package dream.coffee.user.model.entity;

import dream.coffee.user.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * Read Only
 */
@Getter
@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "order_id")
	private Order order;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "product_code")
	private Product product;

	private int totalprice;

	private int numberOfProduct;

	@Embedded
	private BaseEntity baseEntity;

	protected OrderItem(){}
}
