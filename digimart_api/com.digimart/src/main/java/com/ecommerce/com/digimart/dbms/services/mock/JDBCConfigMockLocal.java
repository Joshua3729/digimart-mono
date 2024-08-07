package com.ecommerce.com.digimart.dbms.services.mock;

import com.ecommerce.com.digimart.dbms.services.base.IJDBCConfig;
import com.ecommerce.com.digimart.dbms.utilities.HikariConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import com.ecommerce.com.digimart.dbms.versioning.MockProducts;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Primary
@Profile("local")
@Log4j2
@Deprecated
public class JDBCConfigMockLocal implements IJDBCConfig {

    @Value("${spring.datasource.url}")
    String jdbcUrl;

    @Value("${digimart.db.name}")
    String dbName;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${digimart.db.seeddata}")
    Boolean seedData;

    HikariConnectionPool hcp;

    @PostConstruct
    public void initService() {
        log.info("JDBCConfigMockLocal service initialized");
        init();
    }

    public HikariConnectionPool init()
    {
        if (seedData)
        {
            // Seed Database
            MockProducts mockProducts = new MockProducts(jdbcUrl, dbName, username, password);

            try
            {
                //Mock profile entries
                byte[] products = Files.readAllBytes(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("mock_products.csv")).toURI()).toPath());
                List<String[]> productsList = mockProducts.readCsv(products, true);
                if (productsList != null) mockProducts.processAndIngestMockedData(productsList);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }

        this.hcp = new HikariConnectionPool(this.jdbcUrl, this.dbName, this.username, this.password, null);

        return this.hcp;
    }

    @Override
    public Connection getConnection() {
        try
        {
            return this.hcp.getConnection();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return null;
        }
    }
}
