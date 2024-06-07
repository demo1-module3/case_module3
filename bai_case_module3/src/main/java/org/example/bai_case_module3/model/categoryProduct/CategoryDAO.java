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

    public List<CategoryProduct> getAllCategory() throws SQLException{
        List<CategoryProduct> categories = new ArrayList<>();
        String sql = "SELECT * FROM CategoryProduct";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("categoryId");
                String name = rs.getString("categoryName");
                String description = rs.getString("description");
                String status = rs.getString("status");

                Status status1 = Status.valueOf(status);
                CategoryProduct category = new CategoryProduct(id, name, description, status1);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Lỗi khi truy xuất sản phẩm danh mục", e);
        }

        return categories;
    }

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            List<CategoryProduct> categories = categoryDAO.getAllCategory();
            for (CategoryProduct category : categories) {
                System.out.println(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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


