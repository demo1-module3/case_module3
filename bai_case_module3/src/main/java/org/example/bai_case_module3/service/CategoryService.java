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
        // Lấy danh sách các trạng thái (Active, Inactive) từ bảng CategoryProduct
        List<CategoryProduct> categoryProducts = this.categoryDAO.selectAll();
        // Điều hướng đến trang JSP để hiển thị form thêm mới CategoryProduct
        request.setAttribute("categoryProducts", categoryProducts);
        RequestDispatcher out = request.getRequestDispatcher("/views/categoryView/categoryCreate.jsp");
        out.forward(request, response);
    }

    public void renderPageEditCategory(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException, SQLException {
        CategoryProduct categoryProduct = this.categoryDAO.selectById(id);
        request.setAttribute("categoryProduct", categoryProduct);
        List<CategoryProduct> roles = this.categoryDAO.selectAll();
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

    @WebServlet(name = "VerityMoneyController", urlPatterns = "/verityMoney/*")
    public static class VerityMoneyController extends HttpServlet {
        private VerityMoneyService verityMoneyService;
        @Override
        public void init() throws ServletException {
            this.verityMoneyService = new VerityMoneyService();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String url = req.getPathInfo();
            switch (url) {
                case "/list":
                    try {
                        this.verityMoneyService.renderPageListVeritymoney(req, resp);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "/create":
                    try{
                        this.verityMoneyService.rederPageAddVerityMoney(req, resp);
                    }catch (SQLException e){
                        throw new RuntimeException(e);
                    }
                    break;
                case "/edit":
                    try{
                        int id = Integer.parseInt(req.getParameter("VerityMoneyId"));
                        this.verityMoneyService.rederPageAddVerityMoney(req, resp);
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
                        this.verityMoneyService.addNewVerityMoney(req);
                        resp.sendRedirect(req.getContextPath() + "/verityMoney/list");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "/delete":
                    try{
                        int id = Integer.parseInt(req.getParameter("VerityMoneyId"));
                        this.verityMoneyService.deleteVerityMoneyById(id);
                        resp.sendRedirect(req.getContextPath() + "/verityMoney/list");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "/edit":
                    try{
                        this.verityMoneyService.updateVerityMoney(req);
                        resp.sendRedirect(req.getContextPath() + "/verityMoney/list");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }
}
