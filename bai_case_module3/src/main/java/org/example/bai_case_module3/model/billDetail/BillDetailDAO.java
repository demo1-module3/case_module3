package org.example.bai_case_module3.model.billDetail;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.BillDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BillDetailDAO implements IBillDetailDAO{
    private Connection connection;

    public BillDetailDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(BillDetails billDetails) throws SQLException {

    }

    @Override
    public BillDetails selectById(int id) {
        return null;
    }

    @Override
    public List<BillDetails> selectAll() {
        return null;
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