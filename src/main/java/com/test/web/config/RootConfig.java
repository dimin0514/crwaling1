package com.test.web.config;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


//@EnableAspectJAutoProxy
//@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages= {"com.test.web"})
@Import({
	MyBatisConfig.class, ServletConfig.class
})
public class RootConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig hikarConfig = new HikariConfig();
		hikarConfig.setDriverClassName("org.mariadb.jdbc.Driver");
		hikarConfig.setJdbcUrl("jdbc:mariadb://172.168.0.183:3306/mysql");
//		hikarConfig.setJdbcUrl("jdbc:mariadb://172.168.0.150:3306/mysql");
//		hikarConfig.setJdbcUrl("jdbc:mariadb://172.168.0.183:3306/mypet");
		hikarConfig.setUsername("catdog");
		hikarConfig.setPassword("catdog");
		HikariDataSource dataSource = new HikariDataSource(hikarConfig);
		return dataSource;
	}
	@Bean
	public DataSourceTransactionManager txManger() {
		return new DataSourceTransactionManager(dataSource());
	}
//역시 갓정욱
	
	
}





