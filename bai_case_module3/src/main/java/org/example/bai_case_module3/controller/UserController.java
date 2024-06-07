package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.entity.Gender;
import org.example.bai_case_module3.entity.Role;
import org.example.bai_case_module3.entity.Status;
import org.example.bai_case_module3.entity.User;
import org.example.bai_case_module3.model.user.UserDAO;
import org.example.bai_case_module3.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.example.bai_case_module3.Util.DateConversion.convertStringToDate;

@WebServlet(name = "UserServlet", urlPatterns = "/user/*")
public class UserController  extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.userService.renderPageListUser(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/create":
                try {
                    this.userService.rederPageAddUser(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try{
                    int id = Integer.parseInt(req.getParameter("UserID"));
                    this.userService.rederPageEditUser(req, resp, id);
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
                    this.userService.addNewUser(req);
                    resp.sendRedirect(req.getContextPath() + "/user/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/delete":
                try{
                    int id = Integer.parseInt(req.getParameter("UserID"));
                    this.userService.deleteUserById(id);
                    resp.sendRedirect(req.getContextPath() + "/user/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try{
                    this.userService.updateUser(req);
                    resp.sendRedirect(req.getContextPath() + "/user/list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;


        }
    }
}
