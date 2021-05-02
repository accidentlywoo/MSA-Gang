package dream.coffee.user.api.repository.dsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dream.coffee.user.api.model.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderRepository extends QuerydslRepositorySupport {
	@Autowired private JPAQueryFactory queryFactory;

	public OrderRepository() { super(Order.class); }

}
