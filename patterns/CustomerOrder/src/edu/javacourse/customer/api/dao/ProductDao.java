package edu.javacourse.customer.api.dao;

import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.ProductDaoException;
import edu.javacourse.customer.api.filter.ProductFilter;
import java.util.List;

public interface ProductDao
{

    List<Product> getProductList(ProductFilter filter) throws ProductDaoException;

    Integer addProduct(Product product) throws ProductDaoException;

    void updateProduct(Product product) throws ProductDaoException;

    void setActiveStatus(Integer productId, Integer status) throws ProductDaoException;
}
