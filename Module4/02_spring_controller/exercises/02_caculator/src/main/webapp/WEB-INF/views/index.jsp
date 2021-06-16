<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 16/06/2021
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/caculator" method="post">
    <input type="number" id="Lettuce" name="number1">
    <input type="number" id="Tomato" name="number2">
    <div>
        <input type="submit" name="caculator" value="addition">
        <input type="submit" name="caculator" value="subtraction">
        <input type="submit" name="caculator" value="multiplication">
        <input type="submit" name="caculator" value="division">
    </div>

</form>
</body>
</html>
