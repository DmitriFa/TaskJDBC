package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "root";

    public Util() {

    }

    public  Connection databaseConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.println("Driver loaded success");

            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connection success");
                conn.setAutoCommit(false);
                return conn;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection failed...");
        }

        return null;
    }

    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("jm/task/core/jdbc/model/hibernate.cfg.xml");
                configuration.addAnnotatedClass(User.class);
               StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory =  configuration.buildSessionFactory(builder.build());
              //
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }

    }
