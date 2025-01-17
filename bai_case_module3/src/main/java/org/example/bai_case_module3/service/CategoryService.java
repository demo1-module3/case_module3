package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.Status;
import org.example.bai_case_module3.model.categoryProduct.CategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    public void renderPageListCategory(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException, SQLException {
        // goi model de lay data
        List<CategoryProduct> categoryProducts = this.categoryDAO.selectAll();
        // gan data vao requet de gui xuong view
        request.setAttribute("categoryProducts", categoryProducts);
        RequestDispatcher out = request.getRequestDispatcher("/views/categoryView/list.jsp");
        out.forward(request, response);
    }

    public void renderPageAddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher out = request.getRequestDispatcher("/views/categoryView/categoryCreate.jsp");
        out.forward(request, response);
    }

    public void renderPageEditCategory(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException, SQLException {
        CategoryProduct categoryProduct = this.categoryDAO.selectById(id);
        request.setAttribute("categoryProduct", categoryProduct);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/categoryView/categoryEdit.jsp");
        requestDispatcher.forward(request,response);
    }

    public void addNewCategory(HttpServletRequest req) throws ServletException, IOException, SQLException {
        CategoryProduct newCategory = mapReqToCategory(req);
        this.categoryDAO.insertInto(newCategory);
    }

    public CategoryProduct mapReqToCategory(HttpServletRequest req) {
        CategoryProduct categoryProduct = new CategoryProduct();
        categoryProduct.setCategoryName(req.getParameter("CategoryName"));
        categoryProduct.setDescription(req.getParameter("Description"));
        categoryProduct.setStatus(Status.valueOf(req.getParameter("Status").toUpperCase()));

        return categoryProduct;
    }

    public void updateCategory(HttpServletRequest req) throws ServletException, IOException, SQLException {
        CategoryProduct newCategory = mapReqToCategory(req);
        newCategory.setCategoryId(Integer.parseInt(req.getParameter("CategoryId")));
        this.categoryDAO.update(newCategory);
    }

    public void deleteCategoryById(int id) throws ServletException, IOException, SQLException {
        this.categoryDAO.deleteById(id);
    }

}
