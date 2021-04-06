package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productCode;
	private String productName;

	private int price;
	private int currentStock;
	/**
	 * 판매 여부
	 */
	private boolean isSale;

	@Embedded
	private BaseEntity baseEntity;

	protected Product(){}

	public String orderProduct(int orderStock){
		if(orderStock > currentStock)
			throw new IllegalArgumentException("재고수량 초과");

		currentStock-=orderStock;

		return productCode;
	}
}
