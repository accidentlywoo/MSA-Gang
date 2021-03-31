package dream.coffee.order.model.entity;

import dream.coffee.order.model.entity.baseEntity.BaseEntity;
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
	@Embedded
	private BaseEntity baseEntity;

	protected Product(){}


}
