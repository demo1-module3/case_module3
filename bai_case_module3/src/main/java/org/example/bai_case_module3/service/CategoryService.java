package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.model.categoryProduct.CategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

    public void renderPageListBook(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException, SQLException {
        // goi model de lay data
        List<CategoryProduct> categoryProducts = this.categoryDAO.getAllCategory();
        // gan data vao requet de gui xuong view
        request.setAttribute("categoryProducts", categoryProducts);
        RequestDispatcher out = request.getRequestDispatcher("/views/categoryView/list.jsp");
        out.forward(request, response);
    }
}
