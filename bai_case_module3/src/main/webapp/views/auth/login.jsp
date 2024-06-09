<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/8/2024
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login page</h2>
<form action="/auth/login" method="post">
    <label>
        username:
        <input type="text" name="username"/>
    </label>
    <label>
        pass:
        <input name="password" type="password">
    </label>
    <button type="submit">Login</button>
</form>
</body>
</html>
