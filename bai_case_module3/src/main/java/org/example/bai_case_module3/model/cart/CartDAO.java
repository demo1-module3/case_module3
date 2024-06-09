package org.example.bai_case_module3.model.cart;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Cart;
import org.example.bai_case_module3.entity.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {
    private Connection connection;

    public CartDAO() {
        DBConnect dbConnection = new DBConnect();
        connection = dbConnection.getConnection();
    }

    private static final String SELECT_ALL_CART = "call select_all_cart();";

    @Override
    public void insertInto(Cart cart) throws SQLException {

    }

    @Override
    public Cart selectById(int id) {
        return null;
    }

    @Override
    public List<Cart> selectAll() {
        List<Cart> cartList = new ArrayList<>();
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(SELECT_ALL_CART);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int cartId = Integer.parseInt(resultSet.getString("cartId"));
                String fullName = resultSet.getString("fullName");
                int quantityProduct = Integer.parseInt(resultSet.getString("quantityProduct"));
                Double totalPrice = Double.parseDouble(resultSet.getString("totalPrice"));

                User user = new User(fullName);

                cartList.add(new Cart(cartId, user, quantityProduct, totalPrice));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartList;
    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        List<Cart> cartList = cartDAO.selectAll();
        for (Cart cart : cartList) {
            System.out.println(cart.getUserId().getFullName());
            System.out.println(cart.getQuantityProduct());
            System.out.println(cart.getTotalPrice());
        }
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
