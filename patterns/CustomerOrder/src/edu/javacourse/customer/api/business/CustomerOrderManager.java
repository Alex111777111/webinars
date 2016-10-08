package edu.javacourse.customer.api.business;

import edu.javacourse.customer.api.domain.CustomerOrder;
import edu.javacourse.customer.api.exception.CustomerOrderManagerException;
import edu.javacourse.customer.api.filter.CustomerFilter;
import java.util.List;

public interface CustomerOrderManager
{

    Integer addOrder(CustomerOrder customerOrder) throws CustomerOrderManagerException;

    void changeOrderStatus(Integer customerOrderId, Integer status) throws CustomerOrderManagerException;

    List<CustomerOrder> getOrderListForCustomer(String customerId) throws CustomerOrderManagerException;

    List<CustomerOrder> getOrderList(CustomerFilter filter) throws CustomerOrderManagerException;

    CustomerOrder getOrder(Integer customerOrderId) throws CustomerOrderManagerException;
}
