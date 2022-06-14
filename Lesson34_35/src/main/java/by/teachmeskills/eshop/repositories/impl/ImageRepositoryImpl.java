package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ImageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageRepositoryImpl implements ImageRepository {
    private static final String INSERT_NEW_IMAGE = "INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, PRIMARY_FLAG, IMAGE_PATH) values (?, ?, ?, ?)";
    private static final String UPDATE_IMAGE_BY_ID = "UPDATE ESHOP.IMAGES SET CATEGORY_ID=?, PRODUCT_ID=?, PRIMARY_FLAG=?, IMAGE_PATH=? WHERE ID=?";
    private static final String DELETE_IMAGE_BY_ID = "DELETE FROM ESHOP.IMAGES WHERE ID=?";
    private static final String GET_IMAGE_BY_ID = "SELECT * FROM ESHOP.IMAGES WHERE ID=?";
    private static final String GET_ALL_IMAGES = "SELECT * FROM ESHOP.IMAGES";
    private static final String GET_PRIMARY_IMAGES_BY_CATEGORY_ID = "SELECT * FROM ESHOP.IMAGES WHERE CATEGORY_ID = ? AND PRODUCT_ID IS NOT NULL";
    private static final String GET_PRIMARY_IMAGE_BY_PRODUCT_ID = "SELECT * FROM ESHOP.IMAGES WHERE PRIMARY_FLAG=1 AND PRODUCT_ID = ?";
    private static final String GET_ALL_IMAGE_BY_PRODUCT_ID = "SELECT * FROM ESHOP.IMAGES WHERE PRODUCT_ID = ?";
    private static final String GET_ALL_CATEGORIES_IMAGES = "SELECT * FROM ESHOP.IMAGES WHERE PRODUCT_ID IS NULL";
    private static final String GET_ALL_ORDER_PRIMARY_IMAGES_BY_USER_ID = "SELECT * FROM ESHOP.IMAGES I JOIN ESHOP.ORDER_PRODUCTS OP ON I.PRODUCT_ID=OP.PRODUCT_ID JOIN ESHOP.ORDERS O ON O.ID=OP.ORDER_ID WHERE I.PRIMARY_FLAG=1 AND O.USER_ID=? GROUP BY I.IMAGE_PATH";

    @Override
    public Image create(Image entity) {
        Image image = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement createImageStatement = connection.prepareStatement(INSERT_NEW_IMAGE);
            createImageStatement.setInt(1, entity.getCategoryId());
            createImageStatement.setInt(2, entity.getProductId());
            createImageStatement.setBoolean(3, entity.isPrimaryFlag());
            createImageStatement.setString(4, entity.getImagePath());
            createImageStatement.executeUpdate();
            image = getImageById(entity.getId(), connection);
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return image;
    }

    @Override
    public List<Image> read() {
        return getImagesFromBase(GET_ALL_IMAGES);
    }

    @Override
    public Image update(Image entity) {
        Image image = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_IMAGE_BY_ID);
            preparedStatement.setInt(1, entity.getCategoryId());
            preparedStatement.setInt(2, entity.getProductId());
            preparedStatement.setBoolean(3, entity.isPrimaryFlag());
            preparedStatement.setString(4, entity.getImagePath());
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.executeUpdate();
            image = getImageById(entity.getId(), connection);
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return image;
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_IMAGE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Image> getAllCategoriesImages() {
        return getImagesFromBase(GET_ALL_CATEGORIES_IMAGES);
    }

    @Override
    public List<Image> getImagesByProductId(int productId) {
        return getImagesById(productId, GET_ALL_IMAGE_BY_PRODUCT_ID);
    }

    @Override
    public List<Image> getAllOrderPrimaryImagesByUserId(int userId) {
        return getImagesById(userId, GET_ALL_ORDER_PRIMARY_IMAGES_BY_USER_ID);
    }

    @Override
    public List<Image> getPrimaryImagesByCategoryId(int categoryId) {
        return getImagesById(categoryId, GET_PRIMARY_IMAGES_BY_CATEGORY_ID);
    }

    @Override
    public List<Image> getPrimaryImagesByListProducts(List<Product> products) {
        List<Image> images = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            for (Product product : products) {
                PreparedStatement preparedStatement = connection.prepareStatement(GET_PRIMARY_IMAGE_BY_PRODUCT_ID);
                preparedStatement.setInt(1, product.getId());
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    images.add(getResultSetImage(rs));
                }
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return images;
    }

    private List<Image> getImagesById(int id, String request) {
        List<Image> images = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                images.add(getResultSetImage(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return images;
    }

    private List<Image> getImagesFromBase(String request) {
        List<Image> images = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                images.add(getResultSetImage(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return images;
    }

    private Image getImageById(int imageId, Connection connection) throws SQLException {
        Image image = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_IMAGE_BY_ID);
        preparedStatement.setInt(1, imageId);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            image = getResultSetImage(rs);
        }
        return image;
    }

    private Image getResultSetImage(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int categoryId = rs.getInt("category_id");
        int productId = rs.getInt("product_id");
        boolean primaryFlag = rs.getBoolean("primary_flag");
        String imagePath = rs.getString("image_path");
        return Image.builder()
                .id(id)
                .categoryId(categoryId)
                .productId(productId)
                .primaryFlag(primaryFlag)
                .imagePath(imagePath)
                .build();
    }
}

