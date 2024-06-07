package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.service.VerityMoneyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "VerityMoneyController", urlPatterns = "/verityMoney/*")
public class VerityMoneyController extends HttpServlet {
    private VerityMoneyService verityMoneyService;
    @Override
    public void init() throws ServletException {
        this.verityMoneyService = new VerityMoneyService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.verityMoneyService.renderPageListBook(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
