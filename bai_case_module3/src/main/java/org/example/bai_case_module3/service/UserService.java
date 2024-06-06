package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.User;
import org.example.bai_case_module3.model.user.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public void renderPageListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        List<User> users = this.studentModel.getAllStudent();
//        List<Group> groups = this.groupModel.getAllGroup();
//        request.setAttribute("students", students);
//        request.setAttribute("groups", groups);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/list.jsp");
//        requestDispatcher.forward(request,response);
    }
}
