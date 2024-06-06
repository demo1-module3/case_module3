package org.example.bai_case_module3.model.role;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleDAO implements IRoleDAO{
    private Connection connection;

    public RoleDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(Role role) throws SQLException {

    }

    @Override
    public Role selectById(int id) {
        return null;
    }

    @Override
    public List<Role> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        return false;
    }
}
