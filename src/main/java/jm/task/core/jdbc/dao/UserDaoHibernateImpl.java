package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable()throws SQLException {
        String sql = " CREATE TABLE userex " +
                "(id int NOT NULL AUTO_INCREMENT," +
                "nameuser VARCHAR(30)NOT NULL ," +
                "lastnameuser VARCHAR(30) NOT NULL," +
                "ageuser int NOT NULL," +
                "PRIMARY KEY(id));";
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        String sql = "DROP TABLE userex";
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws HibernateException {
     User user = new User(name,lastName,age);
     Session session = Util.getSessionFactory().openSession();
     Transaction tx1 = session.beginTransaction();
     session.save(user);
     tx1.commit();
     session.close();
    }

    @Override
    public void removeUserById(long id)throws HibernateException {
       // user = getAllUsers().get((int) id-1);
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(Util.getSessionFactory().openSession().get(User.class,id));
        tx1.commit();
      // Util.getSessionFactory().openSession().get(User.class, id);
       session.close();
    }

    @Override
    public List<User> getAllUsers() throws SQLException{
        List<User> users = (List<User>)Util.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        String sql = "DELETE FROM userex ";
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        tx1.commit();
        session.close();
    }
}
