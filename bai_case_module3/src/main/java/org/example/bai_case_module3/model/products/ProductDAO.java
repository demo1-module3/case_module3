package org.example.bai_case_module3.model.products;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Products;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO implements IProductDAO{
    private Connection connection;

    public ProductDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(Products products) throws SQLException {

    }

    @Override
    public Products selectById(int id) {
        return null;
    }

    @Override
    public List<Products> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Products products) throws SQLException {
        return false;
    }
}
