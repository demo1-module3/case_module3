package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.service.BillDetailService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BillDetailServlet", urlPatterns = "/billDetail/*")
public class BillDetailController extends HttpServlet {
    private BillDetailService billDetailService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.billDetailService = new BillDetailService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                this.billDetailService.renderPageListBillDetail(req, resp);
                break;

            case "/create":
                this.billDetailService.rederPageAddBillDetail(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                this.billDetailService.addNewBillDetail(req);
                resp.sendRedirect(req.getContextPath() + "/user/list");
                break;

            case "/delete":
                int id = Integer.parseInt(req.getParameter("UserID"));
                this.billDetailService.deleteBillDetailById(id);
                resp.sendRedirect(req.getContextPath() + "/user/list");
                break;


        }
    }
}
