package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.ProductManagerException;
import java.sql.SQLException;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class ProductManagerImplTest
{
    @Before
    public void startUp() throws SQLException {
        TestUtil.clearDatabase();
    }
    
    @Test
    public void testGetProductList() {
        try {
            ProductManagerImpl pm = TestUtil.buildProductManager();
            
            pm.getProductList(null);
        } catch (ProductManagerException ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAddProduct() {
        try {
            ProductManagerImpl pm = TestUtil.buildProductManager();
            
            Product product = new Product();
            product.setProductName("Product1");
            product.setProductPrice(1.0);
            Integer id = pm.addProduct(product);
            
            product.setProductId(id);
            product.setProductPrice(99.0);
            pm.updateProduct(product);
        } catch (ProductManagerException ex) {
            ex.printStackTrace();
            fail();
        }
    }
}
