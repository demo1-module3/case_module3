<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/9/2024
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>

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
    <h1>Edit Product</h1>
    <form class="form-group" action="/product/edit" method="post">
        <input type="hidden" name="ProductId" value="${products.productId}">

        <div class="form-group">
            <label>Product Name:</label>
            <input type="text" class="form-control" id="ProductName" name="ProductName" value="${products.productName}" required>
        </div>

        <div class="form-group">
            <label>User Name:</label>
            <input type="text" name="UserName" size="45" disabled value="${products.userId.fullName}"
                   class="form-control"/>
        </div>

        <div class="form-group">
            <label>Category Name:</label>
            <select class="form-control" id="CategoryName" name="CategoryName">
                <c:forEach items="${categoryProducts}" var="categoryProducts">
                    <option value="${categoryProducts.categoryId}">${categoryProducts.categoryName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Supplier Name:</label>
            <select class="form-control" id="SupplierName" name="SupplierName">
                <c:forEach items="${suppliers}" var="suppliers">
                    <option value="${suppliers.supplierId}">${suppliers.supplierName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Price:</label>
            <input type="number" class="form-control" id="Price" name="Price" required>
        </div>

        <div class="form-group">
            <label>Quantity:</label>
            <input type="number" class="form-control" id="Quantity" name="Quantity" required>
        </div>

        <div class="form-group">
            <label>Description:</label>
            <input type="text" class="form-control" id="Description" name="Description" required>
        </div>

        <div class="form-group">
            <label for="Status">Status:</label>
            <select class="form-control" id="Status" name="Status">
                <option value="ACTIVE" ${products.status == "ACTIVE" ? 'selected' : ''}>Active</option>
                <option value="INACTIVE" ${products.status == "INACTIVE" ? 'selected' : ''}>Inactive</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Update Product</button>
    </form>
</div>
</body>
</html>
