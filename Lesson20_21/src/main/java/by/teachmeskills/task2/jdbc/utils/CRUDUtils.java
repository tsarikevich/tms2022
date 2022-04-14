package by.teachmeskills.task2.jdbc.utils;

import by.teachmeskills.task2.jdbc.model.CityStudent;
import by.teachmeskills.task2.jdbc.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String GET_ALL_STUDENTS_WITH_CITIES_QUERY = "SELECT * FROM students_db.students LEFT JOIN students_db.studentscity ON students.city_id=studentscity.id;";
    private static final String GET_ALL_CITIES_QUERY = "SELECT * FROM students_db.studentscity;";
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO students(name, surname, course,city_id) VALUES(?, ?, ?, ?);";
    private static final String UPDATE_STUDENT_QUERY = "UPDATE students SET course = ? WHERE id = ?;";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM students WHERE id = ?";
    private static final String INSERT_CITY_QUERY = "INSERT INTO studentsCity(id, city) VALUES(?, ?);";
    private static final String DELETE_CITY_QUERY = "DELETE FROM studentsCity WHERE city = ?";

    public static List<Student> getAllStudentsWithCities() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_WITH_CITIES_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int course = rs.getInt("course");
                int city_id = rs.getInt("city_id");
                String city = rs.getString("city");
                students.add(new Student(id, name, surname, course, city_id, city));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<CityStudent> getAllCities() {
        List<CityStudent> cityStudents = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CITIES_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                cityStudents.add(new CityStudent(id, city));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityStudents;
    }

    public static List<Student> addStudent(Student student, CityStudent city) {
        List<Student> updatedStudents = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement insertCityStatement = connection.prepareStatement(INSERT_CITY_QUERY);
            insertCityStatement.setInt(1, city.getId());
            insertCityStatement.setString(2, city.getCity());
            insertCityStatement.executeUpdate();
            PreparedStatement insertStudentStatement = connection.prepareStatement(INSERT_STUDENT_QUERY);
            insertStudentStatement.setString(1, student.getName());
            insertStudentStatement.setString(2, student.getSurname());
            insertStudentStatement.setInt(3, student.getCourse());
            insertStudentStatement.setInt(4, student.getCity_id());
            insertStudentStatement.executeUpdate();
            updatedStudents = getAllStudentsWithCities();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedStudents;
    }

    public static List<CityStudent> addCity(CityStudent city) {
        List<CityStudent> updatedStudentsCities = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITY_QUERY);
            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getCity());
            preparedStatement.executeUpdate();
            updatedStudentsCities = getAllCities();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedStudentsCities;
    }

    public static List<Student> updateStudent(int studentId, int course) {
        List<Student> updatedStudents = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_QUERY);
            preparedStatement.setInt(1, course);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();
            updatedStudents = getAllStudentsWithCities();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedStudents;
    }

    public static List<Student> deleteStudent(int studentId) {
        List<Student> updatedStudents = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_QUERY);
            preparedStatement.setInt(1, studentId);
            preparedStatement.execute();
            updatedStudents = getAllStudentsWithCities();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedStudents;
    }

    public static List<Student> deleteCityStudent(String nameCity) {
        List<Student> updatedCitiesStudents = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITY_QUERY);
            preparedStatement.setString(1, nameCity);
            preparedStatement.execute();
            updatedCitiesStudents = getAllStudentsWithCities();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedCitiesStudents;
    }

}
