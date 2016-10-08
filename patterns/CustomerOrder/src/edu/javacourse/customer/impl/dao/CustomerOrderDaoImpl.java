package edu.javacourse.customer.impl.dao;

import edu.javacourse.customer.api.dao.ConnectionBuilder;
import edu.javacourse.customer.api.dao.CustomerOrderDao;
import edu.javacourse.customer.api.domain.Customer;
import edu.javacourse.customer.api.domain.CustomerOrder;
import edu.javacourse.customer.api.domain.CustomerOrderItem;
import edu.javacourse.customer.api.domain.Product;
import edu.javacourse.customer.api.exception.CustomerOrderDaoException;
import edu.javacourse.customer.api.filter.CustomerFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderDaoImpl implements CustomerOrderDao
{

    private static final String SELECT_ORDER = "SELECT order_id, customer_id, order_number, order_status FROM cp_order";
    private static final String SELECT_ORDER_CUSTOMER = "SELECT order_id, customer_id, order_number, order_status FROM cp_order WHERE customer_id=?";
    private static final String SELECT_ORDER_ONE = "SELECT order_id, customer_id, order_number, order_status FROM cp_order WHERE order_id=?";
    private static final String SELECT_ORDER_ITEM = "SELECT order_item_id, order_id, product_id, quantity, price FROM cp_order_item WHERE order_id=?";

    private static final String INSERT_ORDER = "INSERT INTO cp_order (customer_id, order_number, order_status) VALUES (?, ?, ?)";
    private static final String INSERT_ITEM = "INSERT INTO cp_order_item (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";

    private static final String UPDATE_STATUS = "UPDATE cp_order SET order_status=? WHERE order_id=?";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    @Override
    public Integer addOrder(CustomerOrder customerOrder) throws CustomerOrderDaoException {
        Integer orderId = -1;
        try {
            Connection con = getConnection();
            con.setAutoCommit(false);
            try {
                PreparedStatement pst = con.prepareStatement(INSERT_ORDER, new String[]{"order_id"});
                pst.setString(1, customerOrder.getCustomer().getCustomerId());
                pst.setString(2, customerOrder.getNumber());
                pst.setInt(3, customerOrder.getStatus());
                pst.executeUpdate();

                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    orderId = rs.getInt(1);
                }
                rs.close();
                pst.close();

                PreparedStatement psti = con.prepareStatement(INSERT_ITEM);
                for (CustomerOrderItem coi : customerOrder.getItems()) {
                    psti.setInt(1, orderId);
                    psti.setInt(2, coi.getProduct().getProductId());
                    psti.setInt(3, coi.getCount());
                    psti.setDouble(4, coi.getPrice());
                    psti.addBatch();
                }
                psti.executeBatch();
                psti.close();

                con.commit();
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerOrderDaoException(e);
        }

        return orderId;
    }

    @Override
    public void changeOrderStatus(Integer customerOrderId, Integer status) throws CustomerOrderDaoException {
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(UPDATE_STATUS);
                pst.setInt(1, status);
                pst.setInt(2, customerOrderId);
                pst.executeUpdate();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerOrderDaoException(e);
        }
    }

    @Override
    public List<CustomerOrder> getOrderListForCustomer(String customerId) throws CustomerOrderDaoException {
        List<CustomerOrder> result = new ArrayList<>();
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(SELECT_ORDER_CUSTOMER);
                pst.setString(1, customerId);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    CustomerOrder co = new CustomerOrder();
                    co.setOrderId(rs.getInt("order_id"));
                    Customer c = new Customer();
                    c.setCustomerId(rs.getString("customer_id"));
                    co.setCustomer(c);
                    co.setNumber(rs.getString("order_number"));
                    co.setStatus(rs.getInt("order_status"));

                    result.add(co);
                }
                rs.close();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerOrderDaoException(e);
        }

        return result;
    }

    @Override
    public List<CustomerOrder> getOrderList(CustomerFilter filter) throws CustomerOrderDaoException {
        List<CustomerOrder> result = new ArrayList<>();
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(SELECT_ORDER);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    CustomerOrder co = new CustomerOrder();
                    co.setOrderId(rs.getInt("order_id"));
                    Customer c = new Customer();
                    c.setCustomerId(rs.getString("customer_id"));
                    co.setCustomer(c);
                    co.setNumber(rs.getString("order_number"));
                    co.setStatus(rs.getInt("order_status"));

                    result.add(co);
                }
                rs.close();
                pst.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerOrderDaoException(e);
        }

        return result;
    }

    @Override
    public CustomerOrder getOrder(Integer customerOrderId) throws CustomerOrderDaoException {
        CustomerOrder customerOrder = null;
        try {
            Connection con = getConnection();
            try {
                PreparedStatement pst = con.prepareStatement(SELECT_ORDER_ONE);
                pst.setInt(1, customerOrderId);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    customerOrder = new CustomerOrder();
                    customerOrder.setOrderId(rs.getInt("order_id"));
                    Customer c = new Customer();
                    c.setCustomerId(rs.getString("customer_id"));
                    customerOrder.setCustomer(c);
                    customerOrder.setNumber(rs.getString("order_number"));
                    customerOrder.setStatus(rs.getInt("order_status"));
                }
                rs.close();
                pst.close();

                if (customerOrder != null) {
                    PreparedStatement psti = con.prepareStatement(SELECT_ORDER_ITEM);
                    psti.setInt(1, customerOrderId);
                    ResultSet rsi = psti.executeQuery();
                    List<CustomerOrderItem> coiList = new ArrayList<>();
                    while (rsi.next()) {
                        CustomerOrderItem coi = new CustomerOrderItem();
                        coi.setOrderItemId(rsi.getInt("order_item_id"));
                        Product p = new Product();
                        p.setProductId(rsi.getInt("product_id"));
                        coi.setProduct(p);
                        coi.setCount(rsi.getInt("quantity"));
                        coi.setPrice(rsi.getDouble("price"));

                        coiList.add(coi);
                    }
                    rsi.close();
                    psti.close();

                    customerOrder.setItems(coiList);
                }
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerOrderDaoException(e);
        }

        return customerOrder;

    }
}
