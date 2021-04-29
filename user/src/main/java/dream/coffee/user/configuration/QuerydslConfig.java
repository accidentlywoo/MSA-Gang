package dream.coffee.user.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslConfig {
	@Autowired
	private EntityManager entityManager;

	@Bean
	public JPAQueryFactory jpaQueryFactory(){
		return new JPAQueryFactory(this.entityManager);
	}
}
