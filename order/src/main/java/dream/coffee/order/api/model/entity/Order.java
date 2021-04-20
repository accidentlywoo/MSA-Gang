package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.OrderStatus;
import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;

	private String orderCode;

	private int totalPrice;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	@Embedded
	private BaseEntity baseEntity;

	protected Order(){}

	private Order( OrderStatus status, Member member) {
		this.status = status;
		this.member = member;
	}

	/**
	 * 1) 주문 생성 및 사용자 정보 세팅
	 * 주문 번호 먼저 생성
	 *  주문 번호 : 결재 정보 = 1 : 1
	 *  주문 번호 : 주문 아이템 = 1 : N
	 *
	 *  1) 주문 데이터 생성 -> 2) 주문 코드 생성 -> 3) 주문 아이템 데이터 생성 -> 4) 결제 데이터 생성
	 *
	 * @param member
	 * @return
	 */
	public static Order createOrderInfo( Member member){
		Order order = new Order(OrderStatus.ORDER, member);
		member.getOrders().add(order);
		return order;
	}

	/** TODO
	 * 2) 주문 코드 생성
	 *
	 * @return
	 */
	public Long generateOrderCode(){
		this.orderCode = "~~";
		return this.id;
	}

	/**
	 * 3) 주문 아이템 등록
	 * 주문 정보 - 주문 아이템 정보 세팅
	 *
	 * @param orderItems
	 * @return
	 */
	public Order settingOrderItem(List<OrderItem> orderItems){
		if(this.orderCode == null) {
			throw new IllegalArgumentException("주문 코드가 생성되지 않았습니다.");
		}
		for(OrderItem item : orderItems){
			orderItems.add(item);
			item.setOrderInfo(this);
		}
		return this;
	}

	/**
	 * 4) 결제 정보 생성
	 *
	 * @param aPayment
	 * @return
	 */
	public Order createPaymentInfo(Payment aPayment){
		if(this.orderItems.size() < 1) {
			throw new IllegalArgumentException("주문 상품 정보가 없습니다.");
		}
		for(OrderItem item : this.orderItems){
			this.totalPrice += item.getTotalprice();
		}
		this.payment = aPayment;
		aPayment.setOrderInfo(this);
		return this;
	}



	/**
	 * 주문 상태 변경
	 *
	 * @param status
	 * @return
	 */
	public String changeOrderStatus(OrderStatus status){
		if(this.payment == null || !this.payment.isApproval()) {
			throw new IllegalArgumentException("결제 정보 확인이 필요합니다.");
		}
		this.status = status;
		return this.orderCode;
	}
}
