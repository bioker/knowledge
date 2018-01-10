package net.wls.test.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class Main {

    @Value(value = "${dataSourceDriverClass}")
    private String dataSourceDriverClass;
    @Value(value = "${dataSourceUrl}")
    private String dataSourceUrl;
    @Value(value = "${dataSourceUsername}")
    private String dataSourceUsername;
    @Value(value = "${dataSourcePassword}")
    private String dataSourcePassword;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean
    public DataSource getDataSource() {

        System.out.println("driver class: " + dataSourceDriverClass);
        System.out.println("url: " + dataSourceUrl);
        System.out.println("username: " + dataSourceUsername);
        System.out.println("password: " + dataSourcePassword);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceDriverClass);
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }
}
