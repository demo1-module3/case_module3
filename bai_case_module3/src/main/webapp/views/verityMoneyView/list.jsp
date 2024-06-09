<%@ page import="org.example.bai_case_module3.entity.VerityMoney" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.bai_case_module3.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/6/2024
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%List<VerityMoney> verityMoneyList = (List<VerityMoney>) request.getAttribute("verityMoneys");%>
<%List<User> userList = (List<User>) request.getAttribute("user");%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="card">
            <h1>Category List</h1>
            <div class="card-header">
                <a href="/verityMoney/create" class="btn btn-success">Create</a>
                <table class="table table-hover">
                    <tr>
                        <th>#</th>
                        <th>UserID</th>
                        <th>Money</th>
                        <th>status</th>
                        <th>Actions</th>
                    </tr>
                    <c:set var="i" value="1"/>
                    <c:forEach items="${verityMoneys}" var="verityMoneys">
                        <tr>
                            <td><c:out value="${i}"/></td>
                            <td>
                                     <c:out value="${verityMoneys.userId.fullName}"/>
                            </td>
                            <td><c:out value="${verityMoneys.money}"/> </td>
                            <td><c:out value="${verityMoneys.status}"/> </td>
                            <td>
                                <div style="display: flex;">
                                    <form action="/verityMoney/edit" method="get" class="mt-3" style="margin-right: 10px">
                                        <input type="hidden" name="VerityMoneyId" value="${verityMoneys.verityMoneyId}">
                                        <button type="submit" class="btn btn-Info" style="width: 80px;">Edit</button>
                                    </form>

                                    <form action="/verityMoney/delete" method="post" class="mt-3" onsubmit="return confirm('Bạn có chắc chắn muốn xóa danh mục này?');">
                                        <input type="hidden" name="VerityMoneyId" value="${verityMoneys.verityMoneyId}">
                                        <button type="submit" class="btn btn-danger" style="width: 80px;">Delete</button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                        <c:set var="i" value="${i + 1}"/>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
