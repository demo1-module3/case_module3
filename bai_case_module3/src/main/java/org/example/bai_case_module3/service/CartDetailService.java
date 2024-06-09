package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.BillDetails;
import org.example.bai_case_module3.entity.CartDetails;
import org.example.bai_case_module3.model.cartDetail.CartDetailDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartDetailService {
    private CartDetailDAO cartDetailDAO;
    public CartDetailService(){
        cartDetailDAO = new CartDetailDAO();
    }
    public void renderPageListCartDetail(HttpServletRequest req, HttpServletResponse resp) {
        List<CartDetails> cartDetails = this.cartDetailDAO.selectAll();
        req.setAttribute("cartDetails", cartDetails);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/cartDetailView/list.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
