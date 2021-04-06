package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

/**
 * Read Only
 */
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
}
