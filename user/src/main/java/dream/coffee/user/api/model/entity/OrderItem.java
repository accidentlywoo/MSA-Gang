package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * Read Only
 */
@Getter
@Entity
public class OrderItem extends BaseEntity {
	@Id
	@Column(name = "order_item_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "code")
	private Order order;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "product_code")
	private Product product;

	@Column(nullable = false)
	private int totalprice;

	@Column(nullable = false)
	private int numberOfProduct;

	protected OrderItem(){}
}
