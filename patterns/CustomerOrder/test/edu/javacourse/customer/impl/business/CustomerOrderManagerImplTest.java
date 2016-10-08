package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.domain.CustomerOrder;
import edu.javacourse.customer.api.domain.CustomerOrderItem;
import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.CustomerOrderManagerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class CustomerOrderManagerImplTest
{

    @Before
    public void startUp() throws SQLException {
        TestUtil.clearDatabase();
    }

    @Test
    public void testAddOrder() {
        try {
            CustomerManagerImpl cm = TestUtil.buildCustomerManager();
            ProductManagerImpl pm = TestUtil.buildProductManager();
            CustomerOrderManagerImpl com = TestUtil.buildCustomerOrderManager();

            Customer customer = new Customer();
            customer.setCustomerId("Test");
            customer.setFirstName("FirstName");
            customer.setLastName("LastName");
            customer.setEmail("email@pisem.net");
            cm.addCustomer(customer);

            Product product = new Product();
            product.setProductName("Product1");
            product.setProductPrice(1.0);
            Integer id = pm.addProduct(product);
            product.setProductId(id);

            CustomerOrder co = new CustomerOrder();
            co.setCustomer(customer);
            co.setNumber("12345");
            co.setStatus(1);
            List<CustomerOrderItem> items = new ArrayList<>();
            CustomerOrderItem coi = new CustomerOrderItem();
            coi.setProduct(product);
            coi.setCount(10);
            coi.setPrice(18.0);
            items.add(coi);
            co.setItems(items);

            Integer orderId = com.addOrder(co);

            com.getOrder(orderId);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetOrderList() {
        try {
            CustomerOrderManagerImpl com = TestUtil.buildCustomerOrderManager();

            com.getOrderList(null);
        } catch (CustomerOrderManagerException ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetOrderListForUser() {
        try {
            CustomerOrderManagerImpl com = TestUtil.buildCustomerOrderManager();
            com.getOrderListForCustomer("Test");
        } catch (CustomerOrderManagerException ex) {
            ex.printStackTrace();
            fail();
        }
    }
}
