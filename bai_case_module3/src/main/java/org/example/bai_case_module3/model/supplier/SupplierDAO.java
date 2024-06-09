package org.example.bai_case_module3.model.supplier;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.Status;
import org.example.bai_case_module3.entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierDAO{
    private Connection connection;

    public SupplierDAO(){
        DBConnect dbConnection =new DBConnect();
        this.connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(Supplier supplier) throws SQLException {
        String query = "INSERT INTO Supplier (SupplierName, Address, Status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getAddress());
            statement.setString(3, supplier.getStatus().name());
            statement.executeUpdate();
        }
    }

    @Override
    public Supplier selectById(int id) throws SQLException{
        String sql = "SELECT * FROM Supplier WHERE SupplierID = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapToSupplier(resultSet);
            }
        }
        return null;
    }

    public Supplier mapToSupplier(ResultSet resultSet) throws SQLException {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(resultSet.getInt("SupplierID"));
        supplier.setSupplierName(resultSet.getString("SupplierName"));
        supplier.setAddress(resultSet.getString("Address"));
        supplier.setStatus(Status.valueOf(resultSet.getString("Status").toUpperCase()));
        return supplier;
    }

    @Override
    public List<Supplier> selectAll() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM Supplier";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("SupplierId");
                String name = rs.getString("SupplierName");
                String Address = rs.getString("Address");
                String status = rs.getString("status").toUpperCase();

                Status status1 = Status.valueOf(status);
                Supplier supplier = new Supplier(id, name, Address, status1);
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Lỗi khi truy xuất sản phẩm danh mục", e);
        }
        return suppliers;
    }

    public static void main(String[] args) {
        SupplierDAO supplierDAO = new SupplierDAO();
        try {
            List<Supplier> suppliers = supplierDAO.selectAll();
            for (Supplier supplier : suppliers) {
                System.out.println(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM Supplier WHERE SupplierID = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Supplier supplier) throws SQLException {
        String sql = "UPDATE Supplier SET SupplierName = ?, Address = ?, Status = ? WHERE SupplierID = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, supplier.getSupplierName());
            preparedStatement.setString(2, supplier.getAddress());
            preparedStatement.setString(3, supplier.getStatus().name());
            preparedStatement.setInt(4, supplier.getSupplierId());

            return preparedStatement.executeUpdate() > 0;
        }
    }
}
