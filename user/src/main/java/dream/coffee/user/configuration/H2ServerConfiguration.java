package dream.coffee.user.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.h2.tools.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Profile("local")
public class H2ServerConfiguration {
	public DataSource dataSource() throws SQLException {
		Server.createTcpServer("-tcp","-tcpAllowOthers","-tcpPort", "8082").start();

		return new HikariDataSource();
	}
}
