package edu.javacourse.customer.api.dao;

public interface AbstractDaoFactory
{
    CustomerDao getCustomerDao();
    ProductDao getProductDao();
    CustomerOrderDao getCustomerOrderDao();
}
