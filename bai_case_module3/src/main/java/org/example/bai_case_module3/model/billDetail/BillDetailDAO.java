package org.example.bai_case_module3.model.billDetail;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Bill;
import org.example.bai_case_module3.entity.BillDetails;
import org.example.bai_case_module3.entity.Products;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO implements IBillDetailDAO{
    private Connection connection;

    public BillDetailDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    private static final String SELECT_ALL_BILL_DETAIL= "call select_all_bill_detail();";

    @Override
    public void insertInto(BillDetails billDetails) throws SQLException {

    }

    @Override
    public BillDetails selectById(int id) {
        return null;
    }

    @Override
    public List<BillDetails> selectAll() {
        List<BillDetails> billDetailsList =new ArrayList<>();
        try {
            CallableStatement callableStatement= connection.prepareCall(SELECT_ALL_BILL_DETAIL);
            ResultSet resultSet=callableStatement.executeQuery();

            while (resultSet.next()){
                int billDetailId=resultSet.getInt("billDetailId");
                int billId=resultSet.getInt("billId");
                String productName=resultSet.getString("productName");
                int quantity=resultSet.getInt("quantity");
                double price=resultSet.getDouble("price");
                double totalPrice=resultSet.getDouble("totalPrice");

                Bill bill = new Bill(billId);
                Products products = new Products(productName);

                BillDetails billDetail=new BillDetails(billDetailId,bill,products,quantity,price,totalPrice);
                billDetailsList.add(billDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billDetailsList;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BillDetails billDetails) throws SQLException {
        return false;
    }
}
