package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.Gender;
import org.example.bai_case_module3.entity.Role;
import org.example.bai_case_module3.entity.Status;
import org.example.bai_case_module3.entity.User;
import org.example.bai_case_module3.model.role.RoleDAO;
import org.example.bai_case_module3.model.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.example.bai_case_module3.Util.DateConversion.convertStringToDate;

public class UserService {

    private UserDAO userDAO;
    private RoleDAO roleDAO;

    public UserService() {
        this.userDAO = new UserDAO();
        this.roleDAO = new RoleDAO();
    }

    public void renderPageListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> users = this.userDAO.selectAll();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/userView/list.jsp");
        requestDispatcher.forward(request,response);
    }

    public void rederPageAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Role> roles = this.roleDAO.selectAll();
        request.setAttribute("roles", roles);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/userView/user-create.jsp");
        requestDispatcher.forward(request,response);
    }

    public void rederPageEditUser(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException, SQLException {
        User user = this.userDAO.selectById(id);
        request.setAttribute("user", user);
        List<Role> roles = this.roleDAO.selectAll();
        request.setAttribute("roles", roles);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/userView/user-edit.jsp");
        requestDispatcher.forward(request,response);
    }

    public void addNewUser(HttpServletRequest req) throws ServletException, IOException, SQLException {
        User newUser = mapReqToUser(req);
        this.userDAO.insertInto(newUser);
    }

    public void updateUser(HttpServletRequest req) throws ServletException, IOException, SQLException {
        User newUser = mapReqToUser(req);
        newUser.setUserId(Integer.parseInt(req.getParameter("UserID")));
        this.userDAO.update(newUser);
    }

    public void deleteUserById(int id) throws ServletException, IOException, SQLException {
        this.userDAO.deleteById(id);
    }

    public User mapReqToUser(HttpServletRequest req) {
        User user = new User();
        user.setUsername(req.getParameter("Username"));
        user.setPassword(req.getParameter("Password"));
        user.setFullName(req.getParameter("FullName"));
        user.setDateOfBirth(convertStringToDate(req.getParameter("DateOfBirth"), "yyyy-MM-dd"));
        user.setGender(Gender.valueOf(req.getParameter("Gender").toUpperCase()));
        user.setEmail(req.getParameter("Email"));
        user.setPhoneNumber(String.valueOf(req.getParameter("PhoneNumber")));
        user.setAddress(req.getParameter("Address"));
        user.setWallet(Double.valueOf(req.getParameter("Wallet")));
        user.setStatus(Status.valueOf(req.getParameter("Status").toUpperCase()));
        user.setRoleId(new Role(Integer.parseInt(req.getParameter("RoleId"))));
        return user;
    }
}
