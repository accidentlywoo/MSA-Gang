package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "order_code")
	private Order order;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "product_code")
	private Product product;

	private int totalprice;

	private int numberOfProduct;

	@Embedded
	private BaseEntity baseEntity;

	protected OrderItem(){}

	private OrderItem(Product product, int totalprice, int numberOfProduct) {
		this.product = product;
		this.totalprice = totalprice;
		this.numberOfProduct = numberOfProduct;
	}

	/**
	 * 3) 주문 아이템 생성
	 *
	 * @param product
	 * @param numberOfProduct
	 * @return
	 */
	public static OrderItem createOrderItem(Product product, int numberOfProduct){
		return new OrderItem(product, product.getPrice() * numberOfProduct, numberOfProduct);

	}

	/**
	 * 3) 주문 정보 세팅
	 *
	 * @param aOrder
	 */
	protected void setOrderInfo(Order aOrder){
		this.order = aOrder;
	}
}
