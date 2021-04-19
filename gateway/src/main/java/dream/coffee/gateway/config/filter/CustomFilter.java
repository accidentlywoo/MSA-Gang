package dream.coffee.gateway.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
	public CustomFilter(){
		super(Config.class);
	}
	@Override
	public GatewayFilter apply(Config config) {
		// Custom pre Filter. Suppose we can extract JWT and perform Authentication
		return ((exchange, chain) -> {
			// Spring Cloud Gateway는 기본적으로 Netty 사용. Reactive 가즈아!
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();

			log.info("Custom PRE filter : request uri -> {}", request.getId());
			// Custom Post Filter. Suppose we can call error response handler based on error code.
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("Custom POST filter: response code -> {}", response.getStatusCode());
			}));
		});
	}
	public static class Config{
		// Put the Configuration Properties
	}
}
