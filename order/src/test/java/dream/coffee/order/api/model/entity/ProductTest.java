package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("╯°□°）╯ 상품 정보 조회, 수량 변경 엔터튀 테스트!")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductTest {
	@Autowired
	private ProductRepository productRepository;

	@Test
	@DisplayName("GREEN 상품 제고 빼기")
	public void 상품_제고수량_빼기(){
	    // given
		int subtactStock = 10;

		final Product product = 상품등록_픽스처();

		final int beforeStock = product.getCurrentStock();

		// when
		productRepository.save(product.subtractStock(subtactStock));

		final Optional<Product> after = productRepository.findProductByCode(product.getCode());

		// than
		assertThat(after).isNotEmpty();

		assertThat(after.get())
				.extracting("currentStock","code", "name", "price", "sale")
				.contains(beforeStock - subtactStock, product.getCode(), product.getName(), product.getPrice(), product.isSale());
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,10,20,100})
	@DisplayName("RED 상품 제고 빼기 실패")
	public void 상품_제고수량_빼기_실패(int overStock){
		// given
		final Product product = 상품등록_픽스처();

		int subtactStock = product.getCurrentStock() + overStock;

		assertThatThrownBy(() -> {
			productRepository.save(product.subtractStock(subtactStock));
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("주문 수량을 초과하였습니다. 남은 수량 : " + product.getCurrentStock());
	}

	private Product 상품등록_픽스처(){
		// given
		String name = "test";
		int price = 9999;
		int stock = 99;
		boolean sale = true;

		// when
		final Product product = Product.createProduct(name, price, stock, sale);

		String productCode = product.getCode();

		productRepository.save(product);

		// than
		final Optional<Product> productByCode = productRepository.findProductByCode(productCode);

		assertThat(productByCode).isNotEmpty();

		assertThat(productByCode.get())
				.extracting("name", "price", "currentStock", "sale")
				.contains(name, price, stock, sale);

		return productByCode.get();
	}

//	@Test
	@Rollback(value = false)
	@DisplayName("GREEN 상품 등록 GREEN")
	public void 상품_등록_GREEN(){
		// given
		String name = "earl-gray-tea";
		int price = 6000;
		int stock = 1000;
		boolean sale = true;

		// when
		final Product product = Product.createProduct(name, price, stock, sale);

		String productCode = product.getCode();

		productRepository.save(product);

		// than
		final Optional<Product> productByCode = productRepository.findProductByCode(productCode);

		assertThat(productByCode).isNotEmpty();

		assertThat(productByCode.get())
				.extracting("name", "price", "currentStock", "sale")
				.contains(name, price, stock, sale);
	}
}