<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 31/05/2021
  Time: 9:50 PM
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
<form>
    <div class="form-group">
        <label for="exampleInputEmail">Id Product</label>
        <input type="number" class="form-control" id="exampleInputEmail"
               aria-describedby="emailHelp" name="id">

    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Name</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name="name">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword2">Price</label>
        <input type="number" class="form-control" id="exampleInputPassword2" name="price">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword3">Manufacture</label>
        <input type="text" class="form-control" id="exampleInputPassword3" name="manufacture">
    </div>

    <button type="submit" class="btn btn-primary">Add</button>
</form>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
</body>
</html>
