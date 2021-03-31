package dream.coffee.order.model.entity;

import dream.coffee.order.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

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

	@Embedded
	private BaseEntity baseEntity;

	protected OrderItem(){}


}
