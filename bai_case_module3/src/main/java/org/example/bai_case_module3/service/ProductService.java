package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.BillDetails;
import org.example.bai_case_module3.entity.Products;
import org.example.bai_case_module3.model.products.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;
    public ProductService(){
        productDAO= new ProductDAO();
    }
    public void renderPageListProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Products> products = this.productDAO.selectAll();
        req.setAttribute("products", products);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/productView/list.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
