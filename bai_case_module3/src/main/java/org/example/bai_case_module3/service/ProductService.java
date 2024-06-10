package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.*;
import org.example.bai_case_module3.model.categoryProduct.CategoryDAO;
import org.example.bai_case_module3.model.products.ProductDAO;
import org.example.bai_case_module3.model.supplier.SupplierDAO;
import org.example.bai_case_module3.model.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private SupplierDAO supplierDAO;
    private UserDAO userDAO;

    public ProductService() {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
        supplierDAO = new SupplierDAO();
        userDAO = new UserDAO();
    }

    public void renderPageListProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Products> products = this.productDAO.selectAll();
        req.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/productView/list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void rederPageAddProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<CategoryProduct> categoryProducts = this.categoryDAO.selectAll();
        List<Supplier> suppliers = this.supplierDAO.selectAll();
        req.setAttribute("categoryProducts", categoryProducts);
        req.setAttribute("suppliers", suppliers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/productView/product-create.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void rederPageEditProduct(HttpServletRequest req, HttpServletResponse resp, int id) throws SQLException {
        Products products = this.productDAO.selectById(id);
        List<CategoryProduct> categoryProducts = this.categoryDAO.selectAll();
        List<Supplier> suppliers = this.supplierDAO.selectAll();
        req.setAttribute("products", products);
        req.setAttribute("categoryProducts", categoryProducts);
        req.setAttribute("suppliers", suppliers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/productView/product-edit.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewProduct(HttpServletRequest req) throws SQLException {
        String productName = req.getParameter("ProductName");
        String categoryName = req.getParameter("CategoryName");
        String supplierName = req.getParameter("SupplierName");
        Double price = Double.parseDouble(req.getParameter("Price"));
        int quantity = Integer.parseInt(req.getParameter("Quantity"));
        String description = req.getParameter("Description");

        HttpSession session = req.getSession();
        Integer userID = (Integer) session.getAttribute("userLogin");

        if (userID == null) {
            throw new IllegalArgumentException("UserID is not found in session");
        }

        User user = new User(userID);
        CategoryProduct categoryProduct = this.categoryDAO.selectById(Integer.parseInt(categoryName));
        Supplier supplier = this.supplierDAO.selectById(Integer.parseInt(supplierName));

        if (categoryProduct == null || supplier == null) {
            throw new IllegalArgumentException("Invalid category or supplier ID");
        }

        Products products = new Products(productName, user, categoryProduct, supplier, price, quantity, description);
        try {
            this.productDAO.insertInto(products);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateProduct(HttpServletRequest req) throws SQLException {
        int productId = Integer.parseInt(req.getParameter("ProductId"));
        String productName = req.getParameter("ProductName");
        String userName = req.getParameter("UserName");
        String categoryName = req.getParameter("CategoryName");
        String supplierName = req.getParameter("SupplierName");
        Double price = Double.parseDouble(req.getParameter("Price"));
        int quantity = Integer.parseInt(req.getParameter("Quantity"));
        String description = req.getParameter("Description");
        String status = req.getParameter("Status");

        User user = new User(userName);
        CategoryProduct categoryProduct = this.categoryDAO.selectById(Integer.parseInt(categoryName));
        Supplier supplier = this.supplierDAO.selectById(Integer.parseInt(supplierName));
        Status status1 = Status.valueOf(status);

        if (user == null || categoryProduct == null || supplier == null) {
            throw new IllegalArgumentException("Invalid user, category, or supplier ID");
        }

        Products products = new Products(productId, productName, user, categoryProduct, supplier, price, quantity, description, status1);
        try {
            this.productDAO.update(products);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProductById(int id) throws SQLException {
        this.productDAO.deleteById(id);
    }
}
