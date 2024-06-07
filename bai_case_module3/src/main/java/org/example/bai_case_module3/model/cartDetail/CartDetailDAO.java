package org.example.bai_case_module3.model.cartDetail;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.Cart;
import org.example.bai_case_module3.entity.CartDetails;
import org.example.bai_case_module3.entity.Products;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDetailDAO implements ICartDetailDAO{
    private Connection connection;

    public CartDetailDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    private static final String SELECT_ALL_CART_DETAIL = "call select_all_cart_detail();";

    @Override
    public void insertInto(CartDetails cartDetails) throws SQLException {

    }

    @Override
    public CartDetails selectById(int id) {
        return null;
    }

    @Override
    public List<CartDetails> selectAll() {
        List<CartDetails> cartDetailsList=new ArrayList<>();
        CallableStatement callableStatement=null;
        try {
            callableStatement= connection.prepareCall(SELECT_ALL_CART_DETAIL);
            ResultSet resultSet=callableStatement.executeQuery();

            while (resultSet.next()){
                int cartId=resultSet.getInt("cartId");
                String productName=resultSet.getString("productName");
                int quantity=resultSet.getInt("quantity");
                double price=resultSet.getDouble("price");

                Cart cart=new Cart(cartId);
                Products products=new Products(productName);

                cartDetailsList.add(new CartDetails(cart,products,quantity,price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartDetailsList;
    }

    public static void main(String[] args) {
        CartDetailDAO cartDetailDAO=new CartDetailDAO();
        List<CartDetails> cartDetailsList=cartDetailDAO.selectAll();
        for (CartDetails cartDetails : cartDetailsList) {
            System.out.println(cartDetails);
        }
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
