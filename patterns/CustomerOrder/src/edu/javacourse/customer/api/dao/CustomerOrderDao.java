package edu.javacourse.customer.api.dao;

import edu.javacourse.customer.api.domain.CustomerOrder;
import edu.javacourse.customer.api.exception.CustomerOrderDaoException;
import edu.javacourse.customer.api.filter.CustomerFilter;
import java.util.List;

public interface CustomerOrderDao
{

    Integer addOrder(CustomerOrder customerOrder) throws CustomerOrderDaoException;

    void changeOrderStatus(Integer customerOrderId, Integer status) throws CustomerOrderDaoException;

    List<CustomerOrder> getOrderListForCustomer(String customerId) throws CustomerOrderDaoException;

    List<CustomerOrder> getOrderList(CustomerFilter filter) throws CustomerOrderDaoException;

    CustomerOrder getOrder(Integer customerOrderId) throws CustomerOrderDaoException;
}
