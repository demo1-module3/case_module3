package org.example.bai_case_module3.controller;


import org.example.bai_case_module3.service.SupplierService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SupplierController", urlPatterns = "/supplier/*")
public class SupplierController extends HttpServlet {
    private SupplierService supplierService;

    @Override
    public void init() throws ServletException {
        this.supplierService = new SupplierService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.supplierService.renderPageListSupplier(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/create":
                try {
                    this.supplierService.rederPageAddSupplier(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try{
                    int id = Integer.parseInt(req.getParameter("SupplierId"));
                    this.supplierService.rederPageEditSupplier(req, resp, id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                try{
                    this.supplierService.addNewSupplier(req);
                    resp.sendRedirect(req.getContextPath() + "/category/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/delete":
                try{
                    int id = Integer.parseInt(req.getParameter("CategoryId"));
                    this.supplierService.deleteSupplierById(id);
                    resp.sendRedirect(req.getContextPath() + "/supplier/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try{
                    this.supplierService.updateSupplier(req);
                    resp.sendRedirect(req.getContextPath() + "/supplier/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
          }
    }
}
