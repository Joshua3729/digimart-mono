package com.ecommerce.com.digimart.dbms.utilities;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariConnectionPool
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HikariConnectionPool.class);

    private HikariConfig config = new HikariConfig();
    private HikariDataSource ds;

    public HikariConnectionPool(String JdbcUrl, String dbName, String username, String password, String driverClassName)
    {
        LOGGER.info("JDBC URL: {}", JdbcUrl);
        config.setJdbcUrl(JdbcUrl);

        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        if (driverClassName != null)
        {
            config.setDriverClassName(driverClassName);
        }

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }
}
