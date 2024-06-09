package org.example.bai_case_module3.model.verityMoney;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.Status;
import org.example.bai_case_module3.entity.User;
import org.example.bai_case_module3.entity.VerityMoney;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VerityMoneyDAO implements IVerityMoneyDAO {
    private Connection connection;

    public VerityMoneyDAO(){
        DBConnect dbConnection =new DBConnect();
        this.connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(VerityMoney verityMoney) throws SQLException {
        String query = "INSERT INTO VerityMoney (UserID, Money, Status) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, verityMoney.getUserId().getUserId());
            statement.setDouble(2, verityMoney.getMoney());
            statement.setString(3, verityMoney.getStatus().name());
            statement.executeUpdate();
        }
    }

    @Override
    public VerityMoney selectById(int id) throws SQLException {
        String sql = "SELECT * FROM VerityMoney WHERE VerityMoneyID = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapToVerityMoney(resultSet);
            }
        }

        return null;
    }

    public VerityMoney mapToVerityMoney(ResultSet resultSet) throws SQLException {
        VerityMoney verityMoney = new VerityMoney();
        verityMoney.setVerityMoneyId(resultSet.getInt("VerityMoneyId"));
        verityMoney.setUserId(resultSet.getInt("UserId"));
        verityMoney.setMoney(resultSet.getDouble("Money"));
        verityMoney.setStatus(Status.valueOf(resultSet.getString("Status").toUpperCase()));
        return verityMoney;
    }


    @Override
    public List<VerityMoney> selectAll() throws SQLException {

        List<VerityMoney> verityMoneys = new ArrayList<VerityMoney>();
        String sql = "call select_all_VerityMoney();";

        try (CallableStatement callableStatement = connection.prepareCall(sql)) {
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("verityMoneyId");
//                int idUser = rs.getInt("userId");
                String nameUser = rs.getString("fullName");
                double money = rs.getDouble("money");
                String status = rs.getString("status").toUpperCase();

                User user = new User(nameUser);
                Status status1 = Status.valueOf(status);
                VerityMoney verityMoney = new VerityMoney(id, user, money, status1);
                verityMoneys.add(verityMoney);
            }
        } catch (SQLException e) {
            throw new SQLException("Lỗi khi truy xuất sản phẩm danh mục", e);
        }
        return verityMoneys;
    }

    public static void main(String[] args) {
        VerityMoneyDAO verityMoneyDAO = new VerityMoneyDAO();
        try {
            List<VerityMoney> verityMoneys = verityMoneyDAO.selectAll();
            for (VerityMoney verityMoney : verityMoneys) {
                System.out.println(verityMoney);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM VerityMoney WHERE VerityMoneyID = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(VerityMoney verityMoney) throws SQLException {
        String sql = "UPDATE VerityMoney SET UserID = ?, Money = ?, Status = ? WHERE VerityMoneyID = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, verityMoney.getUserId().getUserId());
            preparedStatement.setDouble(2, verityMoney.getMoney());
            preparedStatement.setString(3, verityMoney.getStatus().name());
            preparedStatement.setInt(4, verityMoney.getVerityMoneyId());

            return preparedStatement.executeUpdate() > 0;
        }
    }
}
