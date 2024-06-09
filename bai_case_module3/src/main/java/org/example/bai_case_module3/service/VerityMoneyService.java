package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.VerityMoney;
import org.example.bai_case_module3.model.verityMoney.VerityMoneyDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class VerityMoneyService {
    private VerityMoneyDAO verityMoneyDAO;

    public VerityMoneyService() {
        this.verityMoneyDAO = new VerityMoneyDAO();
    }

    public void renderPageListBook(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException, SQLException {
        // goi model de lay data
        List<VerityMoney> verityMoneys = this.verityMoneyDAO.selectAll();
        // gan data vao requet de gui xuong view
        request.setAttribute("verityMoneys", verityMoneys);
        RequestDispatcher out = request.getRequestDispatcher("/views/verityMoneyView/list.jsp");
        out.forward(request, response);
    }
}
