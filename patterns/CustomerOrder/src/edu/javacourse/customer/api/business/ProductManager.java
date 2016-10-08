package edu.javacourse.customer.api.business;

import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.ProductManagerException;
import edu.javacourse.customer.api.filter.ProductFilter;
import java.util.List;

public interface ProductManager
{

    List<Product> getProductList(ProductFilter filter) throws ProductManagerException;

    Integer addProduct(Product product) throws ProductManagerException;

    void updateProduct(Product product) throws ProductManagerException;

    void setActive(Integer productId) throws ProductManagerException;

    void setInactive(Integer productId) throws ProductManagerException;
}
