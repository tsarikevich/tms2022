
package by.teachmeskills.task1.jdbc.model;

import by.teachmeskills.task1.jdbc.utils.DbUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String GET_ALL_ITEMS_QUERY = "SELECT DISTINCT * FROM items";
    private static final String INSERT_ITEMS_QUERY = "INSERT INTO items(name, description, price,quantity, availability) VALUES(?, ?, ?,?,?);";
    private static final String UPDATE_ITEMS_QUERY = "UPDATE items SET name = ?, description=?, price=?,quantity=?,availability=? WHERE id = ?;";
    private static final String DELETE_ITEMS_QUERY = "DELETE FROM items WHERE id = ?";

    public static List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ITEMS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int quantity = rs.getInt("quantity");
                boolean isAvailability = rs.getBoolean("availability");
                items.add(new Item(id, name, description, price, quantity, isAvailability));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public static List<Item> addItem(Item item) {
        List<Item> updateItems = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEMS_QUERY);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setBigDecimal(3, item.getPrice());
            preparedStatement.setInt(4, item.getQuantity());
            preparedStatement.setBoolean(5, item.isAvailability());
            preparedStatement.executeUpdate();
            updateItems = getAllItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateItems;
    }

    public static List<Item> updateItem(int id, String name, String description, BigDecimal price, int quantity, Boolean availability) {
        List<Item> updateItems = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ITEMS_QUERY);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setBigDecimal(3, price);
            preparedStatement.setInt(4, quantity);
            preparedStatement.setBoolean(5, availability);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            updateItems = getAllItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateItems;
    }

    public static List<Item> deleteItem(int id) {
        List<Item> updateItems = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ITEMS_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            updateItems = getAllItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateItems;
    }
}