package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public Main() {
    }
    public static void main(String[] args) throws SQLException {
      //  new UserDaoJDBCImpl().dropUsersTable();
       // new UserDaoJDBCImpl().createUsersTable();
        new UserDaoJDBCImpl().removeUserById(1);
     // new UserDaoJDBCImpl().saveUser("Василий", "Быков", (byte) 35);
    //  new UserDaoJDBCImpl().saveUser("Валерий", "Романов", (byte) 53);
     // new UserDaoJDBCImpl().saveUser("Игорь", "Орлов", (byte) 27);
     // new UserDaoJDBCImpl().saveUser("Сергей", "Иванов", (byte) 24);
   //   new UserDaoJDBCImpl().getAllUsers();
    //  new UserDaoJDBCImpl().cleanUsersTable();
    //  new UserDaoJDBCImpl().dropUsersTable();
 //  new UserDaoJDBCImpl().saveUser( null, "Fadejev", (byte) 20);

       //   new UserDaoJDBCImpl().getAllUsers();
     /* try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.println("Driver loaded success");

            try {
                Connection connection = new Util().databaseConnect();
                Statement statement = connection.createStatement();
                 int rows = statement.executeUpdate("INSERT userex(nameuser,lastnameuser,ageuser) VALUES ('Дина', 'Корзун', 23)");
                 System.out.printf("Added %d rows", rows);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection failed...");
        }
      new UserDaoJDBCImpl().removeUserById(35);
       // new UserDaoJDBCImpl().cleanUsersTable();
        // new UserDaoJDBCImpl.createUsersTable();*/
    }

}