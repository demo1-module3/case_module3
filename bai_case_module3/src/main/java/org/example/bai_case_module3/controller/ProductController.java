package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.service.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product/*")
public class ProductController extends HttpServlet {
    private ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                this.productService.renderPageListProduct(req, resp);
                break;
            case "/create":
                try {
                    this.productService.rederPageAddProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/edit":
                try{
                    int id = Integer.parseInt(req.getParameter("ProductID"));
                    this.productService.rederPageEditProduct(req, resp, id);
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
                try {
                    this.productService.addNewProduct(req);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                resp.sendRedirect(req.getContextPath() + "/product/list");
                break;

            case "/delete":
                try {
                    int id = Integer.parseInt(req.getParameter("ProductID"));
                    this.productService.deleteProductById(id);
                    resp.sendRedirect(req.getContextPath() + "/product/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try {
                    this.productService.updateProduct(req);
                    resp.sendRedirect(req.getContextPath() + "/product/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
