package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.Supplier;
import org.example.bai_case_module3.model.categoryProduct.CategoryDAO;
import org.example.bai_case_module3.model.supplier.SupplierDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SupplierService {
    private SupplierDAO supplierDAO;

    public SupplierService() {
        this.supplierDAO = new SupplierDAO();
    }

    public void renderPageListBook(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException, SQLException {
        // goi model de lay data
        List<Supplier> suppliers = this.supplierDAO.getAllSupplier();
        // gan data vao requet de gui xuong view
        request.setAttribute("suppliers", suppliers);
        RequestDispatcher out = request.getRequestDispatcher("/views/supplierView/list.jsp");
        out.forward(request, response);
    }
}
