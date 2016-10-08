package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.business.CustomerManager;
import edu.javacourse.customer.api.dao.CustomerDao;
import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.exception.CustomerDaoException;
import edu.javacourse.customer.api.exception.CustomerManagerException;
import edu.javacourse.customer.api.filter.CustomerFilter;
import java.util.List;

public class CustomerManagerImpl implements CustomerManager
{
    private CustomerDao dao;

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Customer> getCustomerList(CustomerFilter filter) throws CustomerManagerException {
        try {
            return dao.getCustomerList();
        } catch (CustomerDaoException ex) {
            throw new CustomerManagerException(ex);
        }
    }

    @Override
    public void addCustomer(Customer customer) throws CustomerManagerException {
        try {
            dao.addCustomer(customer);
        } catch (CustomerDaoException ex) {
            throw new CustomerManagerException(ex);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerManagerException {
        try {
            dao.updateCustomer(customer);
        } catch (CustomerDaoException ex) {
            throw new CustomerManagerException(ex);
        }
    }

}
