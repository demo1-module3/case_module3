package org.example.bai_case_module3.model.supplier;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Supplier;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SupplierDAO implements ISupplierDAO{
    private Connection connection;

    public SupplierDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(Supplier supplier) throws SQLException {

    }

    @Override
    public Supplier selectById(int id) {
        return null;
    }

    @Override
    public List<Supplier> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Supplier supplier) throws SQLException {
        return false;
    }
}
