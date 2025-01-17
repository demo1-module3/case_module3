package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.model.categoryProduct.CategoryDAO;
import org.example.bai_case_module3.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CategoryController", urlPatterns = "/category/*")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        this.categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.categoryService.renderPageListCategory(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/create":
                try {
                    this.categoryService.renderPageAddCategory(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try{
                    int id = Integer.parseInt(req.getParameter("CategoryId"));
                    this.categoryService.renderPageEditCategory(req, resp, id);
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
                    this.categoryService.addNewCategory(req);
                    resp.sendRedirect(req.getContextPath() + "/category/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/delete":
                try{
                    int id = Integer.parseInt(req.getParameter("CategoryId"));
                    this.categoryService.deleteCategoryById(id);
                    resp.sendRedirect(req.getContextPath() + "/category/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try{
                    this.categoryService.updateCategory(req);
                    resp.sendRedirect(req.getContextPath() + "/category/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
