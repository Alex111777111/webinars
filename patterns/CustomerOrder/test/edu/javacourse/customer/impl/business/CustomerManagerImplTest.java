package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.exception.CustomerManagerException;
import java.sql.SQLException;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class CustomerManagerImplTest
{
    @Before
    public void startUp() throws SQLException {
        TestUtil.clearDatabase();
    }

    @Test
    public void testGetCustomerList() {
        try {
            CustomerManagerImpl cm = TestUtil.buildCustomerManager();
            
            cm.getCustomerList(null);
        } catch (CustomerManagerException ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAddCustomer() {
        try {
            CustomerManagerImpl cm = TestUtil.buildCustomerManager();
            
            Customer c = new Customer();
            c.setCustomerId("Test");
            c.setFirstName("FirstName");
            c.setLastName("LastName");
            c.setEmail("email@pisem.net");
            cm.addCustomer(c);
            
            c.setFirstName("FirstName2");
            cm.updateCustomer(c);
        } catch (CustomerManagerException ex) {
            ex.printStackTrace();
            fail();
        }
    }
}
