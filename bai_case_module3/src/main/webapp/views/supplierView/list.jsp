<%@ page import="org.example.bai_case_module3.entity.Supplier" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/6/2024
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%List<Supplier> suppliers = (List<Supplier>) request.getAttribute("suppliers");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Supplier List</h1>
<table>
    <tr>
        <th>#</th>
        <th>SupplierName</th>
        <th>Address</th>
        <th>status</th>
    </tr>
    <c:set var="i" value="1"/>
    <c:forEach items="${suppliers}" var="suppliers">
        <tr>
            <td><c:out value="${i}"/></td>
            <td><c:out value="${suppliers.supplierName}"/></td>
            <td><c:out value="${suppliers.address}"/></td>
            <td><c:out value="${suppliers.status}"/></td>
        </tr>
        <c:set var="i" value="${i + 1}"/>
    </c:forEach>
</table>
</body>
</html>
