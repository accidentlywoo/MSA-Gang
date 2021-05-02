package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

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

	private Product(String code, String name, int price, int stock, boolean sale) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.currentStock = stock;
		this.sale = sale;
	}

	public static Product createProduct(String name, int price, int stock, boolean sale){
		if (price < 10){
			throw new IllegalArgumentException("상품가격의 최소단위는 10원입니다.");
		}

		if (stock < 0){
			throw new IllegalArgumentException("상품수량은 0개 이상이여야 합니다.");
		}

		return new Product(generateProductCode(name), name, price, stock, sale);
	}

	private static String generateProductCode(String name){
		return name+ LocalDate.now();
	}

	public Product subtractStock(int orderNumberOfProduct){
		if(currentStock < orderNumberOfProduct) {
			throw new IllegalArgumentException("주문 수량을 초과하였습니다.");
		}

		currentStock -= orderNumberOfProduct;

		return this;
	}

}
