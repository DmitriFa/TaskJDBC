package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
    // Session session = Util.getSessionFactory().openSession();
     //   Transaction tx1 = session.beginTransaction();
        //session.save(name,lastName,age);
     //   tx1.commit();
     //   session.close();
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
       // List<User> users = (List<User>) Util.getSessionFactory().openSession().createQuery("From User").list();
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
