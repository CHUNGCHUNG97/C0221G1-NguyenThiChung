<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 11/06/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="/auth?action=login">
    UserName: <input type="text" name="userName"><br>
    Password: <input type="text" name="password"><br>
    <input type="submit" value="login">
</form>
</body>
</html>
