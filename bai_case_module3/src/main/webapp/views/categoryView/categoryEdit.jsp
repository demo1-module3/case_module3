<%@ page import="org.example.bai_case_module3.entity.CategoryProduct" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 6/9/2024
  Time: 1:58 AM
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
        <div class="container">
            <h1>Edit Category Product</h1>
            <form class="form-group" action="/category/edit" method="post">
                <input type="hidden" name="CategoryId" value="${categoryProduct.categoryId}">

                <div class="form-group">
                    <label for="CategoryName">Category Name:</label>
                    <input type="text" class="form-control" id="CategoryName" name="CategoryName" value="${categoryProduct.categoryName}" required>
                </div>

                <div class="form-group">
                    <label for="Description">Description:</label>
                    <input type="text" class="form-control" id="Description" name="Description" value="${categoryProduct.description}" required>
                </div>

                <div class="form-group">
                    <label for="Status">Status:</label>
                    <select class="form-control" id="Status" name="Status">
                        <option value="Active" ${categoryProduct.status == "ACTIVE" ? 'selected' : ''}>Active</option>
                        <option value="Inactive" ${categoryProduct.status == "INACTIVE" ? 'selected' : ''}>Inactive</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Update Category Product</button>
            </form>
        </div>

    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>
