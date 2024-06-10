<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/9/2024
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Add Product</h1>
    <form class="form-group" action="${pageContext.request.contextPath}/product/create" method="post">
        <div class="form-group">
            <label>Product Name:</label>
            <input type="text" class="form-control" id="ProductName" name="ProductName" required>
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

        <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
