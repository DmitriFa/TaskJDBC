package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() throws SQLException {
        Statement statement = null;
        try {
            statement = new Util().databaseConnect().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try { String sql = " CREATE TABLE userex " +
                "(id int NOT NULL AUTO_INCREMENT,"+
                "nameuser VARCHAR(30)NOT NULL ," +
                "lastnameuser VARCHAR(30) NOT NULL," +
                "ageuser int NOT NULL,"+
                "PRIMARY KEY(id));";

            statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            statement.close();
        }
        finally {
            statement.close();
        }

    }

    public void dropUsersTable() throws SQLException {
        Statement statement = null;
        try {
             statement = new Util().databaseConnect().createStatement();
            String sql = "DROP TABLE userex";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
      statement.close();
        }
        finally {
            statement.close();
        }
    }
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT userex (nameuser,lastnameuser,ageuser) Values (?,?,?)";
            preparedStatement = new Util().databaseConnect().prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            preparedStatement.getConnection().commit();
            System.out.println("User с именем: " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
            preparedStatement.close();
        }

            finally {
                preparedStatement.close();
            }
        }


    public void removeUserById(long id) throws SQLException {

        PreparedStatement preparedStatement =null;
        try{
            String sql = "DELETE FROM userex WHERE id = ?";
            preparedStatement =  new Util().databaseConnect().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
           preparedStatement.getConnection().commit();
           // preparedStatement.getConnection().rollback();
        }

        catch (SQLException e) {
            e.printStackTrace();
            preparedStatement.close();
        }

        finally {
            preparedStatement.close();
        }
    }


    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = null;
            try {
                String sql = "SELECT * FROM userex";
                statement = new Util().databaseConnect().createStatement();
                ResultSet rs = statement.executeQuery(sql);
                statement.getConnection().commit();
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
                statement.close();
            } finally {
                statement.close();
            }

            return users;
        }


    public void cleanUsersTable() throws SQLException{
        Statement statement = null;
        try {
            statement = new Util().databaseConnect().createStatement();
            String sql = "DELETE FROM userex ";
            statement.executeUpdate(sql);
            statement.getConnection().commit();

        } catch (SQLException e) {
            e.printStackTrace();
            statement.close();
        }
        finally {
            statement.close();
        }
    }
}
