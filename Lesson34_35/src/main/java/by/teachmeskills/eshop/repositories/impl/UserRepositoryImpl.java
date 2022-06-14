package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.UserRepository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static final String GET_ALL_USERS = "SELECT * FROM ESHOP.USERS";
    private static final String GET_LAST_INSERT_USER = "SELECT * FROM ESHOP.USERS WHERE ID=(SELECT MAX(ID) FROM ESHOP.USERS)";
    private static final String INSERT_NEW_USER = "INSERT INTO ESHOP.USERS (LOGIN, NAME, SURNAME, PASSWORD, DATE_OF_BIRTH, EMAIL) values (?,?,?,?,?,?)";
    private static final String UPDATE_BALANCE_USER_BY_ID = "UPDATE ESHOP.USERS SET BALANCE=? WHERE ID=?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM ESHOP.USERS WHERE ID=?";
    private static final String GET_USER_BY_ID = "SELECT * FROM ESHOP.USERS WHERE ID=?";
    private static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM ESHOP.USERS WHERE LOGIN=? AND PASSWORD=?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM ESHOP.USERS WHERE LOGIN=?";

    @Override
    public User create(User entity) {
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement createUserStatement = connection.prepareStatement(INSERT_NEW_USER);
            createUserStatement.setString(1, entity.getLogin());
            createUserStatement.setString(2, entity.getName());
            createUserStatement.setString(3, entity.getSurname());
            createUserStatement.setString(4, entity.getPassword());
            createUserStatement.setObject(5, entity.getBirthDate());
            createUserStatement.setString(6, entity.getEmail());
            createUserStatement.executeUpdate();
            user = getLastInsertUserFromBase(connection);
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> read() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(getResultSetUser(rs));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User update(User entity) {
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BALANCE_USER_BY_ID);
            preparedStatement.setBigDecimal(1, entity.getBalance());
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
            user = getUserById(entity.getId());
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isUserInBase(User user) {
        User userFromBase = getUserFromBaseByLogin(user);
        return Optional.ofNullable(userFromBase).isPresent();
    }

    @Override
    public User getUserFromBaseByLoginAndPassword(User user) {
        User userFromBase = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN_AND_PASSWORD);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userFromBase = getResultSetUser(rs);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userFromBase;
    }

    @Override
    public User getUserFromBaseByLogin(User user) {
        User userFromBase = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1, user.getLogin());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userFromBase = getResultSetUser(rs);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userFromBase;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = getResultSetUser(rs);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean isUserSuitByLoginAndPassword(User user) {
        User userFromBase = getUserFromBaseByLoginAndPassword(user);
        return Optional.ofNullable(userFromBase).isPresent();
    }

    private User getLastInsertUserFromBase(Connection connection) throws SQLException {
        User user = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_LAST_INSERT_USER);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            user = getResultSetUser(rs);
        }
        return user;
    }

    private User getResultSetUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String login = resultSet.getString("login");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String password = resultSet.getString("password");
        LocalDate birthDate = resultSet.getObject("date_of_birth", LocalDate.class);
        String email = resultSet.getString("email");
        BigDecimal balance = resultSet.getBigDecimal("balance");
        return User.builder()
                .id(id)
                .login(login)
                .name(name)
                .surname(surname)
                .password(password)
                .birthDate(birthDate)
                .email(email)
                .balance(balance)
                .build();
    }
}
