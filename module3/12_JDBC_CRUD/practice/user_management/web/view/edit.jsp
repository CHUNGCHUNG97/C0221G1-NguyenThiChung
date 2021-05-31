<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 28/05/2021
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<form method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Id User</label>
        <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="id"
               value="${user.id}" required readonly>

    </div>
    <div class=" form-group">
        <label for="exampleInputPassword1">Name</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name="name" value="${user.name}">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Email</label>
        <input type="email" class="form-control" id="exampleInputPassword2" name="email" value="${user.email}">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Country</label>
        <input type="text" class="form-control" id="exampleInputPassword3" name="country"
               value="${user.country}">
    </div>

    <button type="submit" class="btn btn-primary">Edit</button>
</form>

</body>
</html>
