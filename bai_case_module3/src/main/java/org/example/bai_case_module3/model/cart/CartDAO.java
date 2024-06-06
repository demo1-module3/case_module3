package org.example.bai_case_module3.model.cart;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Cart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartDAO implements ICartDAO{
    private Connection connection;

    public CartDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(Cart cart) throws SQLException {

    }

    @Override
    public Cart selectById(int id) {
        return null;
    }

    @Override
    public List<Cart> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Cart cart) throws SQLException {
        return false;
    }
}
