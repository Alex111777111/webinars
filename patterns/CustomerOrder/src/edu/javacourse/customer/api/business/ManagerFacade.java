package edu.javacourse.customer.api.business;

import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.domain.CustomerOrder;
import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.CustomerManagerException;
import edu.javacourse.customer.api.exception.CustomerOrderManagerException;
import edu.javacourse.customer.api.exception.ProductManagerException;
import edu.javacourse.customer.api.filter.CustomerFilter;
import edu.javacourse.customer.api.filter.ProductFilter;
import java.util.List;

public class ManagerFacade
{
    private CustomerManager customerManager;
    private ProductManager productManager;
    private CustomerOrderManager customerOrderManager;

    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public void setCustomerOrdermanager(CustomerOrderManager customerOrderManager) {
        this.customerOrderManager = customerOrderManager;
    }
    
    public List<Customer> getCustomerList(CustomerFilter filter) throws CustomerManagerException {
        return customerManager.getCustomerList(filter);
    }

    public void addCustomer(Customer customer) throws CustomerManagerException {
        customerManager.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) throws CustomerManagerException {
        customerManager.updateCustomer(customer);
    }
    
    public List<Product> getProductList(ProductFilter filter) throws ProductManagerException {
        return productManager.getProductList(filter);
    }

    public Integer addProduct(Product product) throws ProductManagerException {
        return productManager.addProduct(product);
    }

    public void updateProduct(Product product) throws ProductManagerException {
        productManager.updateProduct(product);
    }

    public void setActive(Integer productId) throws ProductManagerException {
        productManager.setActive(productId);
    }

    public void setInactive(Integer productId) throws ProductManagerException {
        productManager.setInactive(productId);
    }
    
    public Integer addOrder(CustomerOrder customerOrder) throws CustomerOrderManagerException {
        return customerOrderManager.addOrder(customerOrder);
    }

    public void changeOrderStatus(Integer customerOrderId, Integer status) throws CustomerOrderManagerException {
        customerOrderManager.changeOrderStatus(customerOrderId, status);
    }

    public List<CustomerOrder> getOrderListForCustomer(String customerId) throws CustomerOrderManagerException {
        return customerOrderManager.getOrderListForCustomer(customerId);
    }

    public List<CustomerOrder> getOrderList(CustomerFilter filter) throws CustomerOrderManagerException {
        return customerOrderManager.getOrderList(filter);
    }

    public CustomerOrder getOrder(Integer customerOrderId) throws CustomerOrderManagerException {
        return customerOrderManager.getOrder(customerOrderId);
    }
    
}
