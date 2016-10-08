package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.dao.ConnectionBuilder;
import edu.javacourse.customer.api.domain.CustomerOrder;
import edu.javacourse.customer.impl.dao.ConnectionBuilderFactory;
import edu.javacourse.customer.impl.dao.CustomerDaoImpl;
import edu.javacourse.customer.impl.dao.CustomerOrderDaoImpl;
import edu.javacourse.customer.impl.dao.ProductDaoImpl;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

public class TestUtil
{
    public static void clearDatabase() throws SQLException {
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();

        Connection con = cb.getConnection();
        con.createStatement().executeUpdate("DELETE FROM cp_order_item");
        con.createStatement().executeUpdate("DELETE FROM cp_order");
        con.createStatement().executeUpdate("DELETE FROM cp_product");
        con.createStatement().executeUpdate("DELETE FROM cp_customer");
        con.close();
    }
    
    public static CustomerManagerImpl buildCustomerManager() {
        CustomerManagerImpl cm = new CustomerManagerImpl();
        CustomerDaoImpl dao = new CustomerDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        cm.setDao(dao);
        dao.setConnectionBuilder(cb);
        return cm;
    }

    public static ProductManagerImpl buildProductManager() {
        ProductManagerImpl pm = new ProductManagerImpl();
        ProductDaoImpl dao = new ProductDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        pm.setDao(dao);
        dao.setConnectionBuilder(cb);
        return pm;
    }

    public static CustomerOrderManagerImpl buildCustomerOrderManager() {
        CustomerOrderManagerImpl com = new CustomerOrderManagerImpl();
        CustomerOrderDaoImpl dao = new CustomerOrderDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();

        com.setDao(dao);
        dao.setConnectionBuilder(cb);
        return com;
    }
    
}
