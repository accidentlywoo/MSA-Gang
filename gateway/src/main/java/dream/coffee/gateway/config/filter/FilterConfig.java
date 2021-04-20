package dream.coffee.gateway.config.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/user/**")
						.filters(f -> f.addRequestHeader("user-request", "user-request-header")
									   .addResponseHeader("user-response", "user-response-header")
						)
						.uri("http://localhost:8081/")
				)
				.route(r -> r.path("/order/**")
						.filters(f -> f.addRequestHeader("order-request", "order-request-header")
								.addResponseHeader("order-response", "order-response-header")
						)
						.uri("http://localhost:8082/")
				)
				.route(r -> r.path("/order-process/**")
						.filters(f -> f.addRequestHeader("order-process-request", "order-process-request-header")
								.addResponseHeader("order-process-response", "order-process-response-header")
						)
						.uri("http://localhost:8083/")
				)
				.build();

	}
}
