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

	public Product calculateStock(int orderNumberOfProduct){
		if(currentStock < orderNumberOfProduct) {
			throw new IllegalArgumentException("주문 수량을 초과하였습니다.");
		}
		currentStock = currentStock - orderNumberOfProduct;
		return this;
	}
}
