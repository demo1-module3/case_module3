<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.example.bai_case_module3.entity.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.bai_case_module3.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/6/2024
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Role> roles = (List<Role>) request.getAttribute("roles"); %>
<% User user = (User) request.getAttribute("user"); %>

<html>
<head>
    <title>Title</title>

    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-content: center;
            align-items: center;
            margin-right: auto;
            margin-left: auto;
        }

        form {
            width: 500px;
            margin-right: auto;
            margin-left: auto;
        }
    </style>

    <%--boostrap--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<div class="container">
    <h1>Edit User</h1>
    <form class="form-group" action="/user/edit" method="post">
        <input type="hidden" name="UserID" value="${user.userId}">

        <div class="form-group">
            <label for="Username">Username:</label>
            <input type="text" class="form-control" id="Username" name="Username" value="${user.username}" required>
        </div>

        <div class="form-group">
            <label for="Password">Password:</label>
            <input type="password" class="form-control" id="Password" name="Password" value="${user.password}" required>
        </div>

        <div class="form-group">
            <label for="FullName">Full Name:</label>
            <input type="text" class="form-control" id="FullName" name="FullName" value="${user.fullName}" required>
        </div>

        <div class="form-group">
            <label for="RoleId">Role Name:</label>
            <select class="form-control" id="RoleId" name="RoleId">
                <c:forEach items="${roles}" var="role">
                    <option value="${role.roleId}">${role.roleName} ${role.roleId == user.roleId.roleId ? 'selected' : ''}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="DateOfBirth">Date of Birth:</label>
            <input type="date" class="form-control" id="DateOfBirth" name="DateOfBirth" value="${user.dateOfBirth}" required>
        </div>

        <div class="form-group">
            <label for="Gender">Gender:</label>
            <select class="form-control" id="Gender" name="Gender">
                <option value="MALE" ${user.gender == "MALE" ? 'selected' : ''}>Male</option>
                <option value="FEMALE" ${user.gender == "FEMALE" ? 'selected' : ''}>Female</option>
            </select>
        </div>

        <div class="form-group">
            <label for="Email">Email:</label>
            <input type="email" class="form-control" id="Email" name="Email" value="${user.email}" required>
        </div>

        <div class="form-group">
            <label for="PhoneNumber">Phone Number:</label>
            <input type="text" class="form-control" id="PhoneNumber" name="PhoneNumber" value="${user.phoneNumber}" required>
        </div>

        <div class="form-group">
            <label for="Address">Address:</label>
            <input type="text" class="form-control" id="Address" name="Address" value="${user.address}" required>
        </div>

        <div class="form-group">
            <label for="Wallet">Wallet:</label>
            <input type="number" class="form-control" id="Wallet" name="Wallet" step="1" value="${user.wallet}">
        </div>

        <div class="form-group">
            <label for="Status">Status:</label>
            <select class="form-control" id="Status" name="Status">
                <option value="ACTIVE" ${user.status == "ACTIVE" ? 'selected' : ''}>Active</option>
                <option value="INACTIVE" ${user.status == "INACTIVE" ? 'selected' : ''}>Inactive</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Update User</button>
    </form>
</div>

</body>

<%--boostrap--%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>