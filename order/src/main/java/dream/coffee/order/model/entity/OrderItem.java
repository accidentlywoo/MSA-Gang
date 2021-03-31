package dream.coffee.order.model.entity;

import dream.coffee.order.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "id")
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
