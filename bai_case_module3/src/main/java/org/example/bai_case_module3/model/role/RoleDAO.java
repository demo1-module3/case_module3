package org.example.bai_case_module3.model.role;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Role;
import org.example.bai_case_module3.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public Role selectById(int id) throws SQLException {
        String sql = "SELECT * FROM role WHERE RoleId = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Role role = new Role();
            role.setRoleId(resultSet.getInt("RoleId"));
            role.setRoleName(resultSet.getString("RoleName"));
            role.setRoleDescription(resultSet.getString("Description"));
            return role;
        }
        return null;
    }

    public Role selectByName(String roleName) throws SQLException {
        String sql = "SELECT * FROM role WHERE RoleName = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, roleName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Role role = new Role();
            role.setRoleId(resultSet.getInt("RoleId"));
            role.setRoleName(resultSet.getString("RoleName"));
            role.setRoleDescription(resultSet.getString("Description"));
            return role;
        }
        return null;
    }

    @Override
    public List<Role> selectAll() throws SQLException {
        String sql = "SELECT * FROM role";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Role> roles = new ArrayList<>();
        while (resultSet.next()) {
            Role role = new Role();
            role.setRoleId(resultSet.getInt("RoleId"));
            role.setRoleName(resultSet.getString("RoleName"));
            role.setRoleDescription(resultSet.getString("Description"));
            roles.add(role);
        }
        return roles;
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
