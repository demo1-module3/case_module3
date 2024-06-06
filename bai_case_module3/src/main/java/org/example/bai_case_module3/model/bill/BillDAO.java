package org.example.bai_case_module3.model.bill;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BillDAO implements IBillDAO{
    private Connection connection;

    public BillDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(Bill bill) throws SQLException {

    }

    @Override
    public Bill selectById(int id) {
        return null;
    }

    @Override
    public List<Bill> selectAll() {
        return null;
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
