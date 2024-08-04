package com.ecommerce.com.digimart.dbms.versioning;


import com.ecommerce.com.digimart.dbms.versioning.AMockData;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Log4j2
public class MockProducts extends AMockData
{
    private static final Logger log = LogManager.getLogger(MockProducts.class);

    public MockProducts(String hostAddress, String database, String username, String password)
    {
        super(hostAddress,
                database,
                username,
                password);
    }

    // TODO: Validate rate before processing
    // TODO: Display warning if dates are not ordered correctly
    @Override
    protected void insertData(List<String[]> products)
    {
        log.debug("Adding products to database");
        String saveProductsStatements = "INSERT INTO products (category, description, img_url, name, price, supplier_id, tax_percentage, units_in_stock) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        for (String[] product : products)
        {

                String category = product[0];
                String description = product[1];
                String img_url = product[2];
                String name = product[3];
                String price = product[4];
                String supplier_id = product[5];
                String tax_percentage = product[6];
                String units_in_stock = product[7];


                try (Connection connection = hcp.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(saveProductsStatements)
                )
                {
                    int i = 0;
                    preparedStatement.setString(++i, category);
                    preparedStatement.setString(++i, description);
                    preparedStatement.setString(++i, img_url);
                    preparedStatement.setString(++i, name);
                    preparedStatement.setString(++i, price);
                    preparedStatement.setString(++i, supplier_id);
                    preparedStatement.setString(++i, tax_percentage);
                    preparedStatement.setString(++i, units_in_stock);
                    preparedStatement.executeUpdate();
                }
                catch (SQLException throwable)
                {
                    log.error(throwable.getMessage(), throwable);
                }
        }
    }
}
