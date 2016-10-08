package edu.javacourse.customer.api.dao;

import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.exception.CustomerDaoException;
import java.util.List;

public interface CustomerDao
{

    List<Customer> getCustomerList() throws CustomerDaoException;

    void addCustomer(Customer customer) throws CustomerDaoException;

    void updateCustomer(Customer customer) throws CustomerDaoException;
}
