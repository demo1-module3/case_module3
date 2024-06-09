package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.service.CartDetailService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartDetailServlet", urlPatterns = "/cartDetail/*")
public class CartDetailController extends HttpServlet {
    private CartDetailService cartDetailService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.cartDetailService =new CartDetailService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                this.cartDetailService.renderPageListCartDetail(req, resp);
                break;

//            case "/create":
//                this.billDetailService.rederPageAddBillDetail(req, resp);
//                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
