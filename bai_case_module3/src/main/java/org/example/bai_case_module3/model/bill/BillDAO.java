package org.example.bai_case_module3.model.bill;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Bill;
import org.example.bai_case_module3.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements IBillDAO {
    private Connection connection;

    public BillDAO() {
        DBConnect dbConnection = new DBConnect();
        connection = dbConnection.getConnection();
    }

    private static final String SELECT_ALL_BILL = "call select_all_bill();";

    @Override
    public void insertInto(Bill bill) throws SQLException {

    }

    @Override
    public Bill selectById(int id) {
        return null;
    }

    @Override
    public List<Bill> selectAll() {
        List<Bill> billList = new ArrayList<>();
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(SELECT_ALL_BILL);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int billId = resultSet.getInt("billId");
                String fullName = resultSet.getString("fullName");
                double totalAmount = resultSet.getDouble("totalAmount");
                Date billDate = Date.valueOf(resultSet.getString("billDate"));

                User user = new User(fullName);

                billList.add(new Bill(billId, user, totalAmount, billDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billList;
    }

    public static void main(String[] args) {
        BillDAO billDAO = new BillDAO();
        List<Bill> billList = billDAO.selectAll();
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Bill bill) throws SQLException {
        return false;
    }
}
