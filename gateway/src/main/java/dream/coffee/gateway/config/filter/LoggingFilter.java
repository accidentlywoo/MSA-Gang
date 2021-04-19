package dream.coffee.gateway.config.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {
	public LoggingFilter(){
		super(Config.class);
	}
	@Override
	public GatewayFilter apply(Config config) {
		// Custom pre Filter.
//		return ((exchange, chain) -> {
//			ServerHttpRequest request = exchange.getRequest();
//			ServerHttpResponse response = exchange.getResponse();
//
//			log.info("Global Filter baseMessage : {}", config.getBaseMessage());
//
//			if(config.isPreLogger())
//				log.info("Global Filter Start : request id -> {}", request.getId());
//
//			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//				if(config.isPostLogger())
//					log.info("Global Filter End : response code -> {}", response.getStatusCode());
//			}));
//		});
		return new OrderedGatewayFilter((exchange, chain) ->{

			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();

			log.info("Logging Filter baseMessage : {}", config.getBaseMessage());

			if(config.isPreLogger())
				log.info("Logging PRE Filter : request id -> {}", request.getId());

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				if(config.isPostLogger())
					log.info("Logging POST Filter : response code -> {}", response.getStatusCode());
			}));
		}, Ordered.LOWEST_PRECEDENCE); // 우선순위를 Global 보다 높게 잡을 수도 있다.::Ordered.HIGHEST_PRECEDENC

	}

	@Data
	public static class Config{
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;
	}
}
