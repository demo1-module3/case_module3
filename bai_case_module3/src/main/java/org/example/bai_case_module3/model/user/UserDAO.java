package org.example.bai_case_module3.model.user;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO{
    private Connection connection;

    public UserDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }
    @Override
    public void insertInto(User user) throws SQLException {

    }

    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public List<User> selectAll() {

        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }
}
