package org.example.bai_case_module3.model.products;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private Connection connection;

    public ProductDAO() {
        DBConnect dbConnection = new DBConnect();
        connection = dbConnection.getConnection();
    }

    private static final String SELECT_ALL_PRODUCT = "call select_all_product();";

    @Override
    public void insertInto(Products products) throws SQLException {

    }

    @Override
    public Products selectById(int id) {
        return null;
    }

    @Override
    public List<Products> selectAll() {
        List<Products> productsList = new ArrayList<>();
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(SELECT_ALL_PRODUCT);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String productName = resultSet.getString("productName");
                String fullName = resultSet.getString("fullName");
                String categoryName = resultSet.getString("categoryName");
                String supplierName = resultSet.getString("supplierName");
                Double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");

                User user = new User(fullName);
                CategoryProduct categoryProduct = new CategoryProduct(categoryName);
                Supplier supplier = new Supplier(supplierName);
                Status status1 = Status.valueOf(status);

                productsList.add(new Products(productName, user, categoryProduct, supplier, price, quantity, description, status1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productsList;
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<Products> productsList = productDAO.selectAll();
        for (Products products : productsList) {
            System.out.println(products);
        }
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
