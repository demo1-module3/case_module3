package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.BillDetails;
import org.example.bai_case_module3.entity.Cart;
import org.example.bai_case_module3.model.cart.CartDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartService {
    private CartDAO cartDAO;

    public CartService() {
        this.cartDAO = new CartDAO();
    }

    public void renderPageListCart(HttpServletRequest req, HttpServletResponse resp) {
        List<Cart> carts = this.cartDAO.selectAll();
        req.setAttribute("carts", carts);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/cartView/list.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
