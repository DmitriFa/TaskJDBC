package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.databaseConnect;

public class UserDaoJDBCImpl implements UserDao {
private Connection conn = databaseConnect();
    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() throws SQLException {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String sql = " CREATE TABLE userex " +
                    "(id int NOT NULL AUTO_INCREMENT," +
                    "nameuser VARCHAR(30)NOT NULL ," +
                    "lastnameuser VARCHAR(30) NOT NULL," +
                    "ageuser int NOT NULL," +
                    "PRIMARY KEY(id));";

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement.close();
        }

    }

    public void dropUsersTable() throws SQLException {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String sql = "DROP TABLE userex";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement.close();
        }
    }

    public  void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            conn.setAutoCommit(false);
            String sql = "INSERT userex (nameuser,lastnameuser,ageuser) Values (?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            conn.commit();
            System.out.println("User с именем: " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();

        } finally {
            conn.setAutoCommit(true);
            preparedStatement.close();
        }
    }


    public void removeUserById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM userex WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            preparedStatement.close();
        }
    }


    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = null;
        try {
            String sql = "SELECT * FROM userex";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                users.add(user);
                System.out.println(user.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            statement.close();
        }

        return users;
    }


    public void cleanUsersTable() throws SQLException {
        Statement statement = null;
        try {
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            String sql = "DELETE FROM userex ";
            statement.executeUpdate(sql);
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();

        } finally {
            conn.setAutoCommit(true);
            statement.close();
        }
    }
}
