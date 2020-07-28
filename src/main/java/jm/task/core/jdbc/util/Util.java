package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "root";


    public Util() {

    }

    public  static Connection databaseConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.println("Driver loaded success");

            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connection success");
                return conn;
            } catch (SQLException e) {
               e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection failed...");
        }

        return null;
    }

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory()
            throws HibernateException {

     //  public static SessionFactory getSessionFactory() {
         /*    if (sessionFactory == null) {
                try {
                   File file = new File("src/resources/hibernate.cfg.xml");
                    Configuration configuration = new Configuration().configure(file);
                    configuration.addAnnotatedClass(User.class);
                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                    configuration.buildSessionFactory(builder.build());*/
           Configuration configuration = new Configuration()
                   .setProperty("hibernate.connection.driver_class",
                           "com.mysql.cj.jdbc.Driver")
                   .setProperty("hibernate.connection.url",
                           url)
                   .setProperty("hibernate.connection.username",
                           username)
                   .setProperty("hibernate.connection.password",
                           password)
                   .setProperty("hibernate.connection.pool_size", "1")
                   .setProperty("hibernate.connection.autocommit", "false")
                   .setProperty("hibernate.cache.provider_class",
                           "org.hibernate.cache.NoCacheProvider")
                   .setProperty("hibernate.cache.use_second_level_cache",
                           "false")
                   .setProperty("hibernate.cache.use_query_cache", "false")
                   .setProperty("hibernate.dialect",
                           "org.hibernate.dialect.MySQLDialect")
                   .setProperty("hibernate.show_sql", "true")
                   .setProperty("hibernate.current_session_context_class",
                           "thread")
                   .addAnnotatedClass(User.class);

           ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                   configuration.getProperties()).buildServiceRegistry();
           return configuration.buildSessionFactory(serviceRegistry);




          /*  } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }*/
       }
    }
