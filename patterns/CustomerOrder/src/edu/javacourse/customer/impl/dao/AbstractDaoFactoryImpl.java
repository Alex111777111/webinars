package edu.javacourse.customer.impl.dao;

import edu.javacourse.customer.api.dao.AbstractDaoFactory;
import edu.javacourse.customer.api.dao.ConnectionBuilder;
import edu.javacourse.customer.api.dao.CustomerDao;
import edu.javacourse.customer.api.dao.CustomerOrderDao;
import edu.javacourse.customer.api.dao.ProductDao;

public class AbstractDaoFactoryImpl implements AbstractDaoFactory
{

    @Override
    public CustomerDao getCustomerDao() {
        CustomerDaoImpl dao = new CustomerDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public ProductDao getProductDao() {
        ProductDaoImpl dao = new ProductDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public CustomerOrderDao getCustomerOrderDao() {
        CustomerOrderDaoImpl dao = new CustomerOrderDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }
    
}
