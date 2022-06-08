package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.repositories.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private static final String GET_ALL_CATEGORIES = "SELECT * FROM ESHOP.CATEGORIES";
    private static final String INSERT_NEW_CATEGORY = "INSERT INTO ESHOP.CATEGORIES (NAME, RATING) values (?, ?)";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM ESHOP.CATEGORIES WHERE ID=?";
    private static final String UPDATE_CATEGORY_BY_ID = "UPDATE ESHOP.CATEGORIES SET NAME=?, RATING=? WHERE ID=?";
    private static final String DELETE_CATEGORY_BY_ID = "DELETE FROM ESHOP.CATEGORIES WHERE ID=?";

    @Override
    public Category create(Category entity) {
        Category category = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement createCategoryStatement = connection.prepareStatement(INSERT_NEW_CATEGORY);
            createCategoryStatement.setString(1, entity.getName());
            createCategoryStatement.setDouble(2, entity.getRating());
            createCategoryStatement.executeUpdate();
            category = getCategoryById(entity.getId(), connection);
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    @Override
    public List<Category> read() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                categories.add(getResultSetCategory(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category update(Category entity) {
        Category category = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_BY_ID);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getRating());
            preparedStatement.setInt(3, entity.getId());
            preparedStatement.executeUpdate();
            category = getCategoryById(entity.getId(), connection);
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Category getCategoryById(int id, Connection connection) throws SQLException {
        Category category = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            category = getResultSetCategory(rs);
        }
        return category;
    }

    private Category getResultSetCategory(ResultSet resultSet) throws SQLException {
        int idFromBase = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int rating = resultSet.getInt("rating");
        return Category.builder()
                .id(idFromBase)
                .name(name)
                .rating(rating)
                .build();
    }
}
