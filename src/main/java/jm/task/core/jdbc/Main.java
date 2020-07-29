package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import java.sql.SQLException;

public class Main {

    public Main() {
    }
    public static void main(String[] args) throws SQLException {

    new UserDaoHibernateImpl().dropUsersTable();
    new UserDaoHibernateImpl().createUsersTable();
    new UserDaoHibernateImpl().saveUser("Вадим","Анцупов",(byte)38);
    new UserDaoHibernateImpl().saveUser("Василий", "Быков", (byte) 35);
    new UserDaoHibernateImpl().saveUser("Валерий", "Романов", (byte) 53);
   // new UserDaoJDBCImpl().saveUser("Игорь", "Орлов", (byte) 27);
   // new UserDaoJDBCImpl().saveUser("Михаил", "Королёв", (byte) 24);
    // new UserDaoHibernateImpl().getAllUsers();
  //  new UserDaoHibernateImpl().removeUserById(3);
  // new UserDaoHibernateImpl().cleanUsersTable();

    }

}