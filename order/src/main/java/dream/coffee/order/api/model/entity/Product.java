package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Product extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String code;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false)
	private int currentStock;

	@Column(nullable = false)
	private boolean sale;

	protected Product(){}

	public Product calculateStock(int orderNumberOfProduct){
		if(currentStock < orderNumberOfProduct) {
			throw new IllegalArgumentException("주문 수량을 초과하였습니다.");
		}

		currentStock -= orderNumberOfProduct;

		return this;
	}
}
