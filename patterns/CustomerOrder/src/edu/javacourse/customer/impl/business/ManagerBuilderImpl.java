package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.business.CustomerManager;
import edu.javacourse.customer.api.business.CustomerOrderManager;
import edu.javacourse.customer.api.business.ManagerBuilder;
import edu.javacourse.customer.api.business.ManagerFacade;
import edu.javacourse.customer.api.business.ProductManager;
import edu.javacourse.customer.api.dao.ConnectionBuilder;
import edu.javacourse.customer.api.dao.CustomerDao;
import edu.javacourse.customer.api.dao.CustomerOrderDao;
import edu.javacourse.customer.api.dao.ProductDao;
import edu.javacourse.customer.impl.dao.AbstractDaoFactoryImpl;
import edu.javacourse.customer.impl.dao.ConnectionBuilderFactory;
import edu.javacourse.customer.impl.dao.CustomerDaoImpl;
import edu.javacourse.customer.impl.dao.CustomerOrderDaoImpl;
import edu.javacourse.customer.impl.dao.ProductDaoImpl;

public class ManagerBuilderImpl implements ManagerBuilder
{
    private ManagerFacade managerFacade;
    
    @Override
    public void createManagerFacade() {
        managerFacade = new ManagerFacade();
    }

    @Override
    public CustomerManager createCustomerManager() {
        CustomerManagerImpl cm = new CustomerManagerImpl();
        CustomerDao dao = new AbstractDaoFactoryImpl().getCustomerDao();
        cm.setDao(dao);
        
        managerFacade.setCustomerManager(cm);
        
        return cm;
    }

    @Override
    public ProductManager createProductManager() {
        ProductManagerImpl pm = new ProductManagerImpl();
        ProductDao dao = new AbstractDaoFactoryImpl().getProductDao();
        pm.setDao(dao);
        
        managerFacade.setProductManager(pm);
        
        return pm;
    }

    @Override
    public CustomerOrderManager createCustomerOrderManager() {
        CustomerOrderManagerImpl com = new CustomerOrderManagerImpl();
        CustomerOrderDao dao = new AbstractDaoFactoryImpl().getCustomerOrderDao();
        com.setDao(dao);

        managerFacade.setCustomerOrdermanager(com);
        
        return com;
    }

    @Override
    public ManagerFacade getResult() {
        return managerFacade;
    }
    
}
