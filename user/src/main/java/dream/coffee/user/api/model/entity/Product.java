package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

/**
 * Read Only
 */
@Getter
@Entity
public class Product extends BaseEntity{
	@Id
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
}
