package com.ecommerce.com.digimart.dbms.services.base;

import java.sql.Connection;

@Deprecated
public interface IJDBCConfig
{
    Connection getConnection();
}

