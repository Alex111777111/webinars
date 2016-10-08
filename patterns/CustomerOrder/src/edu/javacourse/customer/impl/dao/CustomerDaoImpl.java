package edu.javacourse.customer.impl.dao;

import edu.javacourse.customer.api.dao.ConnectionBuilder;
import edu.javacourse.customer.api.dao.CustomerDao;
import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.exception.CustomerDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao
{
    private static final String SELECT = "SELECT customer_id, first_name, last_name, email FROM cp_customer";
    private static final String INSERT = "INSERT INTO cp_customer (customer_id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE cp_customer SET first_name=?, last_name=?, email=? WHERE customer_id=?";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }
    
    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }
    
    @Override
    public List<Customer> getCustomerList() throws CustomerDaoException {
        List<Customer> result = new ArrayList<>();

        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(SELECT);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId(rs.getString("customer_id"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                    customer.setEmail(rs.getString("email"));

                    result.add(customer);
                }
                rs.close();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerDaoException(e);
        }

        return result;
    }

    @Override
    public void addCustomer(Customer customer) throws CustomerDaoException {
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(INSERT);
                pst.setString(1, customer.getCustomerId());
                pst.setString(2, customer.getFirstName());
                pst.setString(3, customer.getLastName());
                pst.setString(4, customer.getEmail());
                pst.executeUpdate();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerDaoException(e);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerDaoException {
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(UPDATE);
                pst.setString(1, customer.getFirstName());
                pst.setString(2, customer.getLastName());
                pst.setString(3, customer.getEmail());
                pst.setString(4, customer.getCustomerId());
                pst.executeUpdate();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerDaoException(e);
        }
    }
    
}
