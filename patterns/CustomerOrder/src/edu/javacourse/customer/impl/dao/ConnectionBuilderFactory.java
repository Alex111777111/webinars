package edu.javacourse.customer.impl.dao;

import edu.javacourse.customer.api.dao.ConnectionBuilder;

public class ConnectionBuilderFactory
{
    public static ConnectionBuilder getConnectionBuilder() {
        return ConnectionBuilderImpl.getInstance();
    }
}
