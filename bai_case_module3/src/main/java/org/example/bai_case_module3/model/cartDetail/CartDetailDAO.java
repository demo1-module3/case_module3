package org.example.bai_case_module3.model.cartDetail;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.CartDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartDetailDAO implements ICartDetailDAO{
    private Connection connection;

    public CartDetailDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(CartDetails cartDetails) throws SQLException {

    }

    @Override
    public CartDetails selectById(int id) {
        return null;
    }

    @Override
    public List<CartDetails> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(CartDetails cartDetails) throws SQLException {
        return false;
    }
}
