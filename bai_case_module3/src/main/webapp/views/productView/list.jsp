<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/6/2024
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>All Product</h1>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Product Name</th>
        <th>Full Name</th>
        <th>Category Name</th>
        <th>Supplier Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Description</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="i" value="1"/>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${i}</td>
            <td>${product.productName}</td>
            <td>${product.userId.fullName}</td>
            <td>${product.categoryId.categoryName}</td>
            <td>${product.supplierId.supplierName}</td>
            <td><fmt:formatNumber value="${product.price}" pattern="#,##0"/></td>
            <td>${product.quantity}</td>
            <td>${product.description}</td>
            <td>${product.status}</td>

            <td>
                <div style="display: flex;">
                    <form action="cart/create" method="get" class="mt-3" style="margin-right: 10px">
                        <input type="hidden" name="UserID" value="${user.userId}">
                        <button type="submit" class="btn btn-Info" style="width: 80px;">Edit</button>
                    </form>

                    <form action="user/delete" method="post" class="mt-3"
                          onsubmit="return confirm('Are you sure you want to delete this user?');">
                        <input type="hidden" name="UserID" value="${user.userId}">
                        <button type="submit" class="btn btn-danger" style="width: 80px;">Delete</button>
                    </form>
                </div>
            </td>
        </tr>
        <c:set var="i" value="${i + 1}"/>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
