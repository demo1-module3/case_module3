package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.Status;
import org.example.bai_case_module3.entity.User;
import org.example.bai_case_module3.entity.VerityMoney;
import org.example.bai_case_module3.model.user.UserDAO;
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
    private UserDAO userDAO;

    public VerityMoneyService() {
        this.verityMoneyDAO = new VerityMoneyDAO();
        this.userDAO = new UserDAO();

    }

    public void renderPageListVeritymoney(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException, SQLException {
        // goi model de lay data
        List<VerityMoney> verityMoneys = this.verityMoneyDAO.selectAll();
//        List<User> users = this.userDAO.selectAll();
        // gan data vao requet de gui xuong view
        request.setAttribute("verityMoneys", verityMoneys);
//        request.setAttribute("users", users);
        RequestDispatcher out = request.getRequestDispatcher("/views/verityMoneyView/list.jsp");
        out.forward(request, response);
    }

    public void rederPageAddVerityMoney(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> users = this.userDAO.selectAll();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/verityMoneyView/verityMoneyCreate.jsp");
        dispatcher.forward(request, response);
    }

    public void addNewVerityMoney(HttpServletRequest req) throws ServletException, IOException, SQLException {
        VerityMoney newVerityMoney = mapReqToVerityMoney(req);
        this.verityMoneyDAO.insertInto(newVerityMoney);
    }

    public VerityMoney mapReqToVerityMoney(HttpServletRequest req) {
        VerityMoney verityMoney = new VerityMoney();
        verityMoney.setUserId(Integer.parseInt(req.getParameter("UserID")));
        verityMoney.setMoney(Double.parseDouble(req.getParameter("Money")));
        verityMoney.setStatus(Status.valueOf(req.getParameter("Status").toUpperCase()));
        // Assuming VerityMoneyID is generated automatically in the database
        return verityMoney;
    }

    public void updateVerityMoney(HttpServletRequest req) throws ServletException, IOException, SQLException {
        VerityMoney newVerityMoney = mapReqToVerityMoney(req);
        newVerityMoney.setVerityMoneyId(Integer.parseInt(req.getParameter("VerityMoneyID")));
        this.verityMoneyDAO.update(newVerityMoney);
    }

    public void deleteVerityMoneyById(int id) throws ServletException, IOException, SQLException {
        this.verityMoneyDAO.deleteById(id);
    }
}
