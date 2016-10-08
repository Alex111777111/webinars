package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.business.CustomerOrderManager;
import edu.javacourse.customer.api.dao.CustomerOrderDao;
import edu.javacourse.customer.api.domain.CustomerOrder;
import edu.javacourse.customer.api.exception.CustomerOrderDaoException;
import edu.javacourse.customer.api.exception.CustomerOrderManagerException;
import edu.javacourse.customer.api.filter.CustomerFilter;
import java.util.List;

public class CustomerOrderManagerImpl implements CustomerOrderManager
{
    private CustomerOrderDao dao;

    public void setDao(CustomerOrderDao dao) {
        this.dao = dao;
    }
    
    @Override
    public Integer addOrder(CustomerOrder customerOrder) throws CustomerOrderManagerException {
        try {
            return dao.addOrder(customerOrder);
        } catch (CustomerOrderDaoException ex) {
            throw new CustomerOrderManagerException(ex);
        }
    }

    @Override
    public List<CustomerOrder> getOrderListForCustomer(String customerId) throws CustomerOrderManagerException {
        try {
            return dao.getOrderListForCustomer(customerId);
        } catch (CustomerOrderDaoException ex) {
            throw new CustomerOrderManagerException(ex);
        }
    }

    @Override
    public List<CustomerOrder> getOrderList(CustomerFilter filter) throws CustomerOrderManagerException {
        try {
            return dao.getOrderList(filter);
        } catch (CustomerOrderDaoException ex) {
            throw new CustomerOrderManagerException(ex);
        }
    }

    @Override
    public void changeOrderStatus(Integer customerOrderId, Integer status) throws CustomerOrderManagerException {
        try {
            dao.changeOrderStatus(customerOrderId, status);
        } catch (CustomerOrderDaoException ex) {
            throw new CustomerOrderManagerException(ex);
        }
    }

    @Override
    public CustomerOrder getOrder(Integer customerOrderid) throws CustomerOrderManagerException {
        try {
            return dao.getOrder(customerOrderid);
        } catch (CustomerOrderDaoException ex) {
            throw new CustomerOrderManagerException(ex);
        }
    }
    
}
