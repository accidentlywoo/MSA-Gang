package dream.coffee.orderProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessApplication.class, args);
	}

}
