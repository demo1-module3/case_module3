<%@ page import="org.example.bai_case_module3.model.categoryProduct.CategoryDAO" %>
<%@ page import="org.example.bai_case_module3.entity.CategoryProduct" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/6/2024
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%List<CategoryProduct> categoryProducts = (List<CategoryProduct>) request.getAttribute("categories"); %>
<html>
    <head>
        <title>Title</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
<%--    <div class="container">--%>
<%--        <div class="card">--%>
<%--            <h1>Category List</h1>--%>
<%--            <div class="card-header">--%>
<%--                <a href="/verityMoney/create" class="btn btn-success">Create</a>--%>
<%--                <table class="table table-hover">--%>
<%--                    <h1>Category List</h1>--%>
<%--                        <tr>--%>
<%--                            <th>#</th>--%>
<%--                            <th>categoryName</th>--%>
<%--                            <th>description</th>--%>
<%--                            <th>status</th>--%>
<%--                        </tr>--%>
<%--                        <c:set var="i" value="1"/>--%>
<%--                        <c:forEach items="${categoryProducts}" var="categoryProducts">--%>
<%--                            <tr>--%>
<%--                                <td><c:out value="${i}"/></td>--%>
<%--                                <td><c:out value="${categoryProducts.categoryName}"/> </td>--%>
<%--                                <td><c:out value="${categoryProducts.description}"/> </td>--%>
<%--                                <td><c:out value="${categoryProducts.status}"/> </td>--%>
<%--                            </tr>--%>
<%--                            <c:set var="i" value="${i + 1}"/>--%>
<%--                        </c:forEach>--%>
<%--                    </table>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<div class="container">
    <div class="card">
        <h1>Category List</h1>
        <div class="card-header">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Category Name</th>
                <th>Description</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categoryProducts}" var="categoryProduct">
                <tr>
                    <td>${categoryProduct.categoryName}</td>
                    <td>${categoryProduct.description}</td>
                    <td>${categoryProduct.status}</td>
                    <td>
                        <div style="display: flex;">
                            <form action="/categoryProduct/edit" method="get" class="mt-3" style="margin-right: 10px">
                                <input type="hidden" name="CategoryId" value="${categoryProduct.categoryId}">
                                <button type="submit" class="btn btn-Info" style="width: 80px;">Edit</button>
                            </form>

                            <form action="/categoryProduct/delete" method="post" class="mt-3" onsubmit="return confirm('Bạn có chắc chắn muốn xóa danh mục này?');">
                                <input type="hidden" name="CategoryId" value="${categoryProduct.categoryId}">
                                <button type="submit" class="btn btn-danger" style="width: 80px;">Delete</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
