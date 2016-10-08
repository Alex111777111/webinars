package edu.javacourse.customer.impl.dao;

import edu.javacourse.customer.api.dao.ConnectionBuilder;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionBuilderImpl2 implements ConnectionBuilder
{

    @Override
    public Connection getConnection() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
