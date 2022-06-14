package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ProductRepository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static final String INSERT_NEW_PRODUCT = "INSERT INTO ESHOP.PRODUCTS (NAME, DESCRIPTION, PRICE, CATEGORY_ID) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT_BY_ID = "UPDATE ESHOP.PRODUCTS SET NAME=?, DESCRIPTION=?, PRICE=?, CATEGORY_ID=? WHERE ID=?";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM ESHOP.PRODUCTS WHERE ID=?";
    private static final String GET_LAST_INSERT_PRODUCT = "SELECT * FROM ESHOP.PRODUCTS WHERE ID=(SELECT MAX(ID) FROM ESHOP.PRODUCTS)";
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM ESHOP.PRODUCTS";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM ESHOP.PRODUCTS WHERE ID=?";
    private static final String GET_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM ESHOP.PRODUCTS P WHERE P.CATEGORY_ID=?";
    private static final String GET_PRODUCT_BY_ORDER_ID = "SELECT * FROM ESHOP.PRODUCTS P JOIN ESHOP.ORDER_PRODUCTS OP ON P.ID = OP.PRODUCT_ID JOIN ESHOP.ORDERS O ON O.ID = OP.ORDER_ID WHERE O.ID = ?";
    private static final String FIND_ALL_PRODUCTS_BY_REQUEST = "SELECT * FROM ESHOP.PRODUCTS WHERE DESCRIPTION LIKE ? OR NAME LIKE ?";
    private static final String GET_LAST_INSERT_ORDER_PRODUCTS_BY_USER_ID = "SELECT * FROM ESHOP.PRODUCTS P JOIN ESHOP.ORDER_PRODUCTS OP ON P.ID = OP.PRODUCT_ID JOIN ESHOP.ORDERS O ON O.ID = OP.ORDER_ID WHERE O.ID=(SELECT MAX(ID) FROM ESHOP.ORDERS WHERE USER_ID=?)";

    @Override
    public Product create(Product entity) {
        Product product = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement createProductStatement = connection.prepareStatement(INSERT_NEW_PRODUCT);
            createProductStatement.setString(1, entity.getName());
            createProductStatement.setString(2, entity.getDescription());
            createProductStatement.setBigDecimal(3, entity.getPrice());
            createProductStatement.setInt(4, entity.getCategoryId());
            createProductStatement.executeUpdate();
            product = getLastInsertProductFromBase(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> read() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(getResultSetProduct(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Product update(Product entity) {
        Product product = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setBigDecimal(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getCategoryId());
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.executeUpdate();
            product = getProductById(entity.getId());
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                product = getResultSetProduct(rs);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY_ID);
            preparedStatement.setInt(1, categoryId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(getResultSetProduct(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Map<Product, Integer> getProductsByOrderId(int orderId) {
        return getProductsWithNumbersById(orderId, GET_PRODUCT_BY_ORDER_ID);
    }

    @Override
    public Map<Product, Integer> getLastInsertOrderProductsByUserId(int userId) {
        return getProductsWithNumbersById(userId, GET_LAST_INSERT_ORDER_PRODUCTS_BY_USER_ID);
    }

    @Override
    public List<Product> findAllProductsByRequest(String request) {
        List<Product> products = new ArrayList<>();
        String setRequest = "%" + request + "%";
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_PRODUCTS_BY_REQUEST);
            preparedStatement.setString(1, setRequest);
            preparedStatement.setString(2, setRequest);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(getResultSetProduct(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    private Product getLastInsertProductFromBase(Connection connection) throws SQLException {
        Product product = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_LAST_INSERT_PRODUCT);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            product = getResultSetProduct(rs);
        }
        return product;
    }

    private Map<Product, Integer> getProductsWithNumbersById(int id, String request) {
        Map<Product, Integer> products = new HashMap<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = getResultSetProduct(rs);
                int numbersProduct = rs.getInt("numbers_product");
                products.put(product, numbersProduct);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    private Product getResultSetProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        BigDecimal price = resultSet.getBigDecimal("price");
        int categoryId = resultSet.getInt("category_id");
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .categoryId(categoryId)
                .build();
    }
}

