package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ConnectionPool;
import by.teachmeskills.eshop.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final ConnectionPool connectionPool;
    private final ProductRepositoryImpl productRepository;
    private static final String GET_ALL_ORDERS = "SELECT * FROM ESHOP.ORDERS";
    private static final String UPDATE_USER_ID_ORDER_BY_ID = "UPDATE ESHOP.ORDERS SET USER_ID=? WHERE ID=?";
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM ESHOP.ORDERS WHERE ID=?";
    private static final String GET_ORDERS_BY_USER_ID = "SELECT * FROM ESHOP.ORDERS WHERE USER_ID=?";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM ESHOP.ORDERS WHERE ID=?";
    private static final String GET_LAST_INSERT_ORDER_BY_USER_ID = "SELECT * FROM ESHOP.ORDERS WHERE ID=(SELECT MAX(ID) FROM ESHOP.ORDERS WHERE USER_ID=?)";
    private static final String INSERT_NEW_ORDER = "INSERT INTO ESHOP.ORDERS (PRICE, DATE, USER_ID) values (?,?,?)";
    private static final String INSERT_ORDER_PRODUCTS = "INSERT INTO ESHOP.ORDER_PRODUCTS (ORDER_ID, PRODUCT_ID, NUMBERS_PRODUCT) VALUES (?, ?, ?)";

    public OrderRepositoryImpl(ConnectionPool connectionPool, ProductRepositoryImpl productRepository) {
        this.connectionPool = connectionPool;
        this.productRepository = productRepository;
    }

    @Override
    public Order create(Order entity) {
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement createOrderStatement = connection.prepareStatement(INSERT_NEW_ORDER);
            createOrderStatement.setBigDecimal(1, entity.getPrice());
            createOrderStatement.setObject(2, entity.getDate());
            createOrderStatement.setInt(3, entity.getUserId());
            createOrderStatement.executeUpdate();
            order = getLastInsertOrderByUserId(entity.getUserId(), connection);
            for (Map.Entry<Product, Integer> entry : entity.getProducts().entrySet()) {
                insertDataInTableOrder_Products(connection, order.getId(), entry.getKey().getId(), entry.getValue());
            }
            Map<Product, Integer> products = productRepository.getLastInsertOrderProductsByUserId(entity.getUserId());
            order.setProducts(products);
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public List<Order> read() {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                orders.add(getResultSetOrderWithProducts(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    @Override
    public Order update(Order entity) {
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_ID_ORDER_BY_ID);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getId());
            preparedStatement.executeUpdate();
            order = getOrderById(entity.getId(), connection);
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDERS_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                orders.add(getResultSetOrderWithProducts(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    private Order getOrderById(int orderId, Connection connection) throws SQLException {
        Order order = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID);
        preparedStatement.setInt(1, orderId);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            order = getResultSetOrderWithProducts(rs);
        }
        return order;
    }

    private Order getResultSetOrderWithProducts(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt("id");
        BigDecimal price = resultSet.getBigDecimal("price");
        LocalDateTime date = resultSet.getObject("date", LocalDateTime.class);
        int userIdFromBase = resultSet.getInt("user_id");
        Map<Product, Integer> products = productRepository.getProductsByOrderId(orderId);
        return Order.builder()
                .id(orderId)
                .price(price)
                .date(date)
                .products(products)
                .userId(userIdFromBase)
                .build();
    }

    private void insertDataInTableOrder_Products(Connection connection, int orderId, int productId, int numbersProduct) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_PRODUCTS);
        preparedStatement.setInt(1, orderId);
        preparedStatement.setInt(2, productId);
        preparedStatement.setInt(3, numbersProduct);
        preparedStatement.executeUpdate();
    }

    private Order getLastInsertOrderByUserId(int userId, Connection connection) throws SQLException {
        Order order = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_LAST_INSERT_ORDER_BY_USER_ID);
        preparedStatement.setInt(1, userId);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            BigDecimal price = rs.getBigDecimal("price");
            LocalDateTime date = rs.getObject("date", LocalDateTime.class);
            int userIdFromBase = rs.getInt("user_id");
            order = Order.builder()
                    .id(id)
                    .price(price)
                    .date(date)
                    .userId(userIdFromBase)
                    .build();
        }
        return order;
    }
}
