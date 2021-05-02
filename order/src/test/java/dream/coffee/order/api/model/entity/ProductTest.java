package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
	@DisplayName("GREEN 상품 조회")
	public void 상품_조회(){
		// given
		// when
		// than
	}

	@Test
	@DisplayName("GREEN 상품 제고 빼기")
	public void 상품_제고수량_빼기(){
	    // given
	    // when
	    // than
	}

	@Test
	@DisplayName("RED 상품 제고 빼기 실패")
	public void 상품_제고수량_빼기_실패(){
		// given
		// when
		// than
	}

	@Rollback(value = false)
	@Test
	@DisplayName("GREEN 상품 등록 GREEN")
	public void 상품_등록_GREEN(){
		// given
		String name = "book";
		int price = 10000;
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