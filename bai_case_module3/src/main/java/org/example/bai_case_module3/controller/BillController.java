package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.service.BillService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BillServlet", urlPatterns = "/bill/*")
public class BillController extends HttpServlet {
    private BillService billService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.billService =new BillService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.billService.renderPageListBill(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/add":
                try {
                    this.billService.renderPageAddBill(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/delete":
                try {
                    this.billService.deleteBill(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
