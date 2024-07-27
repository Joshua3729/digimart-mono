package com.ecommerce.com.digimart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile({"!rds-bridged"})
public class DataSourceConfig {
    @Value("${digimart.datasource.params.source}")
    private String dataSourceSource;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    private static final String ENVIRONMENT = System.getenv("ENVIRONMENT");

    @Bean
//    @DependsOn("ParameterStorePropertySource")
    public DataSource getMySqlDataSource(DataSourceProperties properties){
        String connectionString = null;
        String username = null;
        String password = null;

        if(dataSourceSource.equals("properties")){
            connectionString = this.url;
            username = this.username;
            password = this.password;
        }

        return DataSourceBuilder.create()
//                .type(SshTunnelingHikariDataSource.class)
                .driverClassName(driver)
                .url(connectionString)
                .username(username)
                .password(password)
                .build();
    }
}
