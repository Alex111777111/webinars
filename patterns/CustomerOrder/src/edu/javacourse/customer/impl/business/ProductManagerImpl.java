package edu.javacourse.customer.impl.business;

import edu.javacourse.customer.api.business.ProductManager;
import edu.javacourse.customer.api.dao.ProductDao;
import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.ProductDaoException;
import edu.javacourse.customer.api.exception.ProductManagerException;
import edu.javacourse.customer.api.filter.ProductFilter;
import java.util.List;

public class ProductManagerImpl implements ProductManager
{
    private ProductDao dao;

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getProductList(ProductFilter filter) throws ProductManagerException {
        try {
            List<Product> list = dao.getProductList(filter);
            return list;
        } catch (ProductDaoException ex) {
            throw new ProductManagerException(ex);
        }
    }

    @Override
    public Integer addProduct(Product product) throws ProductManagerException {
        try {
            Integer id = dao.addProduct(product);
            return id;
        } catch (ProductDaoException ex) {
            throw new ProductManagerException(ex);
        }
    }

    @Override
    public void updateProduct(Product product) throws ProductManagerException {
        try {
            dao.updateProduct(product);
        } catch (ProductDaoException ex) {
            throw new ProductManagerException(ex);
        }
    }

    @Override
    public void setActive(Integer productId) throws ProductManagerException {
        try {
            dao.setActiveStatus(productId, 1);
        } catch (ProductDaoException ex) {
            throw new ProductManagerException(ex);
        }
    }

    @Override
    public void setInactive(Integer productId) throws ProductManagerException {
        try {
            dao.setActiveStatus(productId, 0);
        } catch (ProductDaoException ex) {
            throw new ProductManagerException(ex);
        }
    }
    
}
