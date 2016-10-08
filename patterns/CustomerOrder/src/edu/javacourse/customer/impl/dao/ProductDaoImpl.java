package edu.javacourse.customer.impl.dao;

import edu.javacourse.customer.api.dao.ConnectionBuilder;
import edu.javacourse.customer.api.dao.ProductDao;
import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.ProductDaoException;
import edu.javacourse.customer.api.filter.ProductFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao
{
    private static final String SELECT = "SELECT product_id, product_name, product_price FROM cp_product";
    private static final String INSERT = "INSERT INTO cp_product (product_name, product_price) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE cp_product SET product_name=?, product_price=? WHERE product_id=?";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }
    
    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    @Override
    public List<Product> getProductList(ProductFilter filter) throws ProductDaoException {
        List<Product> result = new ArrayList<>();

        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(SELECT);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getDouble("product_price"));

                    result.add(product);
                }
                rs.close();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductDaoException(e);
        }

        return result;
    }

    @Override
    public Integer addProduct(Product product) throws ProductDaoException {
        Integer result = -1;
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(INSERT, new String[] {"product_id"});
                pst.setString(1, product.getProductName());
                pst.setDouble(2, product.getProductPrice());
                pst.executeUpdate();
                
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next()) {
                    result = rs.getInt(1);
                }
                rs.close();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductDaoException(e);
        }
        return result;
    }

    @Override
    public void updateProduct(Product product) throws ProductDaoException {
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(UPDATE);
                pst.setString(1, product.getProductName());
                pst.setDouble(2, product.getProductPrice());
                pst.setInt(3, product.getProductId());
                pst.executeUpdate();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductDaoException(e);
        }
    }

    @Override
    public void setActiveStatus(Integer productId, Integer status) throws ProductDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
