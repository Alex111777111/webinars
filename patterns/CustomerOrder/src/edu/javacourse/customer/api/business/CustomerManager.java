package edu.javacourse.customer.api.business;

import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.exception.CustomerManagerException;
import edu.javacourse.customer.api.filter.CustomerFilter;
import java.util.List;

public interface CustomerManager
{

    List<Customer> getCustomerList(CustomerFilter filter) throws CustomerManagerException;

    void addCustomer(Customer customer) throws CustomerManagerException;

    void updateCustomer(Customer customer) throws CustomerManagerException;
}
