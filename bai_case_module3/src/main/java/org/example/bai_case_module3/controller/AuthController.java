package org.example.bai_case_module3.controller;

import org.example.bai_case_module3.service.AuthService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/auth/*")
public class AuthController extends HttpServlet {
    private AuthService authService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.authService = new AuthService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        System.out.println(url);
        switch (url) {
            case "/login":
                this.authService.renderPageLogin(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/login":
                this.authService.login(req, resp);
                break;
        }
    }
}
