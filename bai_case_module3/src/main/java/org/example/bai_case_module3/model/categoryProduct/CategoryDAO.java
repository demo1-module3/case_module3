package org.example.bai_case_module3.model.categoryProduct;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.CategoryProduct;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    private Connection connection;

    public CategoryDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(CategoryProduct categoryProduct) throws SQLException {

    }

    @Override
    public CategoryProduct selectById(int id) {
        return null;
    }

    @Override
    public List<CategoryProduct> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(CategoryProduct categoryProduct) throws SQLException {
        return false;
    }
}
