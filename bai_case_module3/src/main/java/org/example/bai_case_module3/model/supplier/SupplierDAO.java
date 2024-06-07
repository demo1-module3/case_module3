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

    public List<Supplier> getAllSupplier() throws SQLException{
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM Supplier";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("SupplierId");
                String name = rs.getString("SupplierName");
                String Address = rs.getString("Address");
                String status = rs.getString("status");

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
            List<Supplier> suppliers = supplierDAO.getAllSupplier();
            for (Supplier supplier : suppliers) {
                System.out.println(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
