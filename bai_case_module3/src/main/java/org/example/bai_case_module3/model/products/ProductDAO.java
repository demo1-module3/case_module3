package org.example.bai_case_module3.model.products;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private Connection connection;

    public ProductDAO() {
        DBConnect dbConnection = new DBConnect();
        connection = dbConnection.getConnection();
    }
    private static final String SELECT_ALL_PRODUCT = "call select_all_product();";
    private static final String SELECT_BY_ID_PRODUCT = "call select_by_id_product(?);";
    private static final String INSERT_PRODUCT = "call insert_into_product(?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_PRODUCT = "update products set productName=?, categoryId=?, supplierId=?, price=?, quantity=?, description=?, status=? where productId = ?";
    private static final String DELETE_PRODUCT = "delete from products where productId=?";

    @Override
    public void insertInto(Products products) throws SQLException {
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(INSERT_PRODUCT);
            callableStatement.setString(1, products.getProductName());
            callableStatement.setInt(2, products.getUserId().getUserId());
            callableStatement.setInt(3, products.getCategoryId().getCategoryId());
            callableStatement.setInt(4, products.getSupplierId().getSupplierId());
            callableStatement.setDouble(5, products.getPrice());
            callableStatement.setInt(6, products.getQuantity());
            callableStatement.setString(7, products.getDescription());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Products selectById(int id) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(SELECT_BY_ID_PRODUCT);
        callableStatement.setInt(1, id);
        ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet.next()) {
            Products products = new Products();
            products.setProductId(resultSet.getInt("productId"));
            products.setProductName(resultSet.getString("productName"));
            products.setUserId(new User(resultSet.getString("fullName")));
            products.setCategoryId(new CategoryProduct(resultSet.getString("categoryName")));
            products.setSupplierId(new Supplier(resultSet.getString("supplierName")));
            products.setPrice(resultSet.getDouble("price"));
            products.setQuantity(resultSet.getInt("quantity"));
            products.setDescription(resultSet.getString("description"));
            products.setStatus(Status.valueOf(resultSet.getString("status").toUpperCase()));
            return products;
        }
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
                int productId = Integer.parseInt(resultSet.getString("productId"));
                String productName = resultSet.getString("productName");
                String fullName = resultSet.getString("fullName");
                String categoryName = resultSet.getString("categoryName");
                String supplierName = resultSet.getString("supplierName");
                Double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status").toUpperCase();

                User user = new User(fullName);
                CategoryProduct categoryProduct = new CategoryProduct(categoryName);
                Supplier supplier = new Supplier(supplierName);
                Status status1 = Status.valueOf(status);

                productsList.add(new Products(productId, productName, user, categoryProduct, supplier, price, quantity, description, status1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productsList;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        boolean rowDelete;
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
        preparedStatement.setInt(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean update(Products products) throws SQLException {
        boolean rowUpdate;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
        preparedStatement.setString(1, products.getProductName());
//        preparedStatement.setInt(2, products.getUserId().getUserId());
        preparedStatement.setInt(2, products.getCategoryId().getCategoryId());
        preparedStatement.setInt(3, products.getSupplierId().getSupplierId());
        preparedStatement.setDouble(4, products.getPrice());
        preparedStatement.setInt(5, products.getQuantity());
        preparedStatement.setString(6, products.getDescription());
        preparedStatement.setString(7, products.getStatus().name());
        preparedStatement.setInt(8, products.getProductId());

        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;
    }
}
