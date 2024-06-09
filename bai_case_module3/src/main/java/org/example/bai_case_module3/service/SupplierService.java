package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.CategoryProduct;
import org.example.bai_case_module3.entity.Status;
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

    public void renderPageListSupplier(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException, SQLException {
        // goi model de lay data
        List<Supplier> suppliers = this.supplierDAO.selectAll();
        // gan data vao requet de gui xuong view
        request.setAttribute("suppliers", suppliers);
        RequestDispatcher out = request.getRequestDispatcher("/views/supplierView/list.jsp");
        out.forward(request, response);
    }

    public void rederPageAddSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        // Retrieve list of categories from the database
        List<Supplier> suppliers = this.supplierDAO.selectAll();

        // Forward to the JSP page to display the form for adding a new supplier
        request.setAttribute("suppliers", suppliers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/supplierView/supplierCreate.jsp");
        dispatcher.forward(request, response);
    }

    public void rederPageEditSupplier(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException, SQLException {
        Supplier supplier = this.supplierDAO.selectById(id);
        request.setAttribute("supplier", supplier);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/supplierView/supplierEdit.jsp");
        dispatcher.forward(request, response);
    }

    public void addNewSupplier(HttpServletRequest req) throws ServletException, IOException, SQLException {
        Supplier newSupplier = mapReqToSupplier(req);
        this.supplierDAO.insertInto(newSupplier);
    }

    private Supplier mapReqToSupplier(HttpServletRequest req) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(req.getParameter("SupplierName"));
        supplier.setAddress(req.getParameter("Address"));
        supplier.setStatus(Status.valueOf(req.getParameter("Status").toUpperCase()));

        return supplier;
    }

    public void updateSupplier(HttpServletRequest req) throws ServletException, IOException, SQLException {
        Supplier newSupplier = mapReqToSupplier(req);
        newSupplier.setSupplierId(Integer.parseInt(req.getParameter("SupplierId")));
        this.supplierDAO.update(newSupplier);
    }

    public void deleteSupplierById(int id) throws ServletException, IOException, SQLException {
        this.supplierDAO.deleteById(id);
    }

}
