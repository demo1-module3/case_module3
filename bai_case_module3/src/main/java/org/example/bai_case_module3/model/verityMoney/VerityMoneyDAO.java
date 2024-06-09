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

    public List<VerityMoney> getAllVerMoney() throws SQLException {
        List<VerityMoney> verityMoneys = new ArrayList<VerityMoney>();
        String sql = "call select_all_VerityMoney();";

        try (CallableStatement callableStatement = connection.prepareCall(sql)) {
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("verityMoneyId");
                String fullName = rs.getString("fullName");
                double money = rs.getDouble("money");
                String status = rs.getString("status").toUpperCase();

                User user = new User(fullName);
                Status status1 = Status.valueOf(status);
                VerityMoney verityMoney = new VerityMoney(id, user, money, status1);
                verityMoneys.add(verityMoney);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Lỗi khi truy xuất sản phẩm danh mục", e);
        }

        return verityMoneys;
    }

    public static void main(String[] args) {
        VerityMoneyDAO verityMoneyDAO = new VerityMoneyDAO();
        try {
            List<VerityMoney> verityMoneys = verityMoneyDAO.getAllVerMoney();
            for (VerityMoney verityMoney : verityMoneys) {
                System.out.println(verityMoney);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertInto(VerityMoney verityMoney) throws SQLException {

    }

    @Override
    public VerityMoney selectById(int id) {
        return null;
    }

    @Override
    public List<VerityMoney> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(VerityMoney verityMoney) throws SQLException {
        return false;
    }
}
