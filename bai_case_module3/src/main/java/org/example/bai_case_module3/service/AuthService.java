package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.User;
import org.example.bai_case_module3.model.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthService {
    private UserDAO userDAO;

    public AuthService (){
        this.userDAO = new UserDAO();
    }
    public void renderPageLogin(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User userLogin = this.userDAO.findUserByAccount(username, password);
        if (userLogin != null) {
            HttpSession session = req.getSession();
            session.setAttribute("userLogin", userLogin.getUsername());

            resp.sendRedirect("/product/list");
        } else {
            resp.sendRedirect("/auth/login");
        }
    }
}
