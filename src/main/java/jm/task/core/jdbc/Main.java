package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;

public class Main {

    public Main() {
    }
    public static void main(String[] args) throws SQLException {

    new UserDaoJDBCImpl().dropUsersTable();
    new UserDaoJDBCImpl().createUsersTable();
    new UserDaoJDBCImpl().saveUser("Василий", "Быков", (byte) 35);
    new UserDaoJDBCImpl().saveUser("Валерий", "Романов", (byte) 53);
    new UserDaoJDBCImpl().saveUser("Игорь", "Орлов", (byte) 27);
    new UserDaoJDBCImpl().saveUser("Михаил", "Королёв", (byte) 24);
    new UserDaoJDBCImpl().getAllUsers();
    new UserDaoJDBCImpl().removeUserById(1);

    }

}