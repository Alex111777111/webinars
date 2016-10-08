package edu.javacourse.customer.api.business;

public interface ManagerBuilder
{
    void createManagerFacade();
    CustomerManager createCustomerManager();
    ProductManager createProductManager();
    CustomerOrderManager createCustomerOrderManager();
    ManagerFacade getResult();
}
