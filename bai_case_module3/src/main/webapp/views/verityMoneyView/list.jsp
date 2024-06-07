<%@ page import="org.example.bai_case_module3.entity.VerityMoney" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/6/2024
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%List<VerityMoney> verityMoneyList = (List<VerityMoney>) request.getAttribute("verityMoneys");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Category List</h1>
<table>
    <tr>
        <th>#</th>
        <th>UserID</th>
        <th>Money</th>
        <th>status</th>
    </tr>
    <c:set var="i" value="1"/>
    <c:forEach items="${verityMoneys}" var="verityMoneys">
        <tr>
            <td><c:out value="${i}"/></td>
<%--            <td><c:out value="${verityMoneys.User}"/> </td>--%>
            <td><c:out value="${verityMoneys.money}"/> </td>
            <td><c:out value="${verityMoneys.status}"/> </td>
        </tr>
        <c:set var="i" value="${i + 1}"/>
    </c:forEach>
</table>
</body>
</html>
