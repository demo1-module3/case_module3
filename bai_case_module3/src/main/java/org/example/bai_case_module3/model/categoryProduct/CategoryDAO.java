package org.example.bai_case_module3.model.categoryProduct;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    private Connection connection;

    public CategoryDAO(){
        DBConnect dbConnection =new DBConnect();
        this.connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(CategoryProduct categoryProduct) throws SQLException {
        String query = "INSERT INTO CategoryProduct (CategoryName, Description, Status) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, categoryProduct.getCategoryName());
            statement.setString(2, categoryProduct.getDescription());
            statement.setString(3, categoryProduct.getStatus().name());
            statement.executeUpdate();
        }
    }

    @Override
    public CategoryProduct selectById(int id) throws SQLException {
        String sql = "SELECT * FROM CategoryProduct WHERE CategoryID = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapToCategoryProduct(resultSet);
            }
        }

        return null;
    }

    public CategoryProduct mapToCategoryProduct(ResultSet resultSet) throws SQLException {
        CategoryProduct categoryProduct = new CategoryProduct();
        categoryProduct.setCategoryId(resultSet.getInt("CategoryID"));
        categoryProduct.setCategoryName(resultSet.getString("CategoryName"));
        categoryProduct.setDescription(resultSet.getString("Description"));
        categoryProduct.setStatus(Status.valueOf(resultSet.getString("Status").toUpperCase()));
        return categoryProduct;
    }

    @Override
    public List<CategoryProduct> selectAll() throws SQLException {
        List<CategoryProduct> categories = new ArrayList<>();
        String sql = "SELECT * FROM CategoryProduct";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("categoryId");
                String name = rs.getString("categoryName");
                String description = rs.getString("description");
                String status = rs.getString("status").toUpperCase();

                Status status1 = Status.valueOf(status);
                CategoryProduct category = new CategoryProduct(id, name, description, status1);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new SQLException("Lỗi khi truy xuất sản phẩm danh mục", e);
        }

        return categories;
    }

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            List<CategoryProduct> categories = categoryDAO.selectAll();
            for (CategoryProduct category : categories) {
                System.out.println(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM CategoryProduct WHERE CategoryID = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(CategoryProduct categoryProduct) throws SQLException {
        String sql = "UPDATE CategoryProduct SET CategoryName = ?, Description = ?, Status = ? WHERE CategoryID = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, categoryProduct.getCategoryName());
            preparedStatement.setString(2, categoryProduct.getDescription());
            preparedStatement.setString(3, categoryProduct.getStatus().name());
            preparedStatement.setInt(4, categoryProduct.getCategoryId());

            return preparedStatement.executeUpdate() > 0;
        }
    }
}


