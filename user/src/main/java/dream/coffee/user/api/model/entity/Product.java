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
	private Long id;
	@Column(nullable = false, unique = true)
	private String productCode;
	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private int price;
	@Column(nullable = false)
	private int currentStock;
	/**
	 * 판매 여부
	 */
	@Column(nullable = false)
	private boolean isSale;

	@Embedded
	private BaseEntity baseEntity;

	protected Product(){}
}
