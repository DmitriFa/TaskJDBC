package jm.task.core.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.println("Driver loaded success");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT usertable(iduser,nameuser,lastnameuser,ageuser) VALUES (22, 'Роман', 'Романов', '1996')");
                System.out.printf("Added %d rows", rows);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection failed...");
        }
    }
}