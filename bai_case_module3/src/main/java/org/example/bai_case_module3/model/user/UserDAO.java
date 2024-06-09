package org.example.bai_case_module3.model.user;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Gender;
import org.example.bai_case_module3.entity.Role;
import org.example.bai_case_module3.entity.Status;
import org.example.bai_case_module3.entity.User;
import org.example.bai_case_module3.model.role.RoleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private Connection connection;
    private RoleDAO roleDAO;

    public UserDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
        this.roleDAO = new RoleDAO();
    }
    @Override
    public void insertInto(User user) throws SQLException {
        String query = "INSERT INTO user (Username, Password, FullName, RoleID, DateOfBirth, " +
                "Gender, Email, PhoneNumber, Address, Wallet, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setInt(4, user.getRoleId().getRoleId());
            statement.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
            statement.setString(6, user.getGender().name());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getPhoneNumber());
            statement.setString(9, user.getAddress());
            statement.setDouble(10, user.getWallet());
            statement.setString(11, user.getStatus().name());
            statement.executeUpdate();
        }
    }

    @Override
    public User selectById(int id) throws SQLException {
        String sql = "SELECT u.*, r.RoleName as RoleName FROM user u INNER JOIN role r ON u.RoleID = r.RoleID WHERE UserID = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = mapToUser(resultSet);
            user.setRoleId(new Role(resultSet.getString("RoleName")));
            return user;
        }

        return null;
    }

    @Override
<<<<<<< HEAD
    public List<User> selectAll() {

        return null;
=======
    public List<User> selectAll() throws SQLException{
        String sql = "SELECT u.*, r.RoleName as RoleName FROM user u INNER JOIN role r ON u.RoleID = r.RoleID ORDER BY u.UserId";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = mapToUser(resultSet);
            user.setRoleId(new Role(resultSet.getString("RoleName")));
            users.add(user);
        }

        return users;
>>>>>>> ee746ad5178ea29c18fc4636985b499b7a6a6310
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE UserId = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = "UPDATE user set Username=?, Password=?, FullName=?, RoleID=?, DateOfBirth=?, Gender=?, Email=?, PhoneNumber=?, Address=?, Wallet=?, Status=?" +
                "  WHERE UserID = ?;";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFullName());
        preparedStatement.setInt(4, user.getRoleId().getRoleId());
        preparedStatement.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
        preparedStatement.setString(6, user.getGender().name());
        preparedStatement.setString(7, user.getEmail());
        preparedStatement.setString(8, user.getPhoneNumber());
        preparedStatement.setString(9, user.getAddress());
        preparedStatement.setDouble(10, user.getWallet());
        preparedStatement.setString(11, user.getStatus().name());
        preparedStatement.setInt(12, user.getUserId());
        return preparedStatement.executeUpdate() > 0;
    }

    public User mapToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("UserID"));
        user.setUsername(resultSet.getString("Username"));
        user.setPassword(resultSet.getString("Password"));
        user.setFullName(resultSet.getString("FullName"));
        user.setDateOfBirth(resultSet.getDate("DateOfBirth"));
        user.setGender(Gender.valueOf(resultSet.getString("Gender").toUpperCase()));
        user.setEmail(resultSet.getString("Email"));
        user.setPhoneNumber(String.format("%.0f", resultSet.getDouble("PhoneNumber")));
        user.setAddress(resultSet.getString("Address"));
        user.setWallet(resultSet.getDouble("Wallet"));
        user.setStatus(Status.valueOf(resultSet.getString("Status").toUpperCase()));
        return user;
    }

    public User findUserByAccount(String username, String password){
        String query = "select * from user where Username = ? and Password = ?;";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = mapToUser(resultSet);
                user.setRoleId(new Role(resultSet.getString("roleId")));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
