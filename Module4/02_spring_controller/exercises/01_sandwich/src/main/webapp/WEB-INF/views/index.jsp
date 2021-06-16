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
<form action="/save" method="post">
    <input type="checkbox" id="Lettuce" name="condiment" value="Lettuce">
    <label for="Lettuce"> Lettuce</label>
    <input type="checkbox" id="Tomato" name="condiment" value="Tomato">
    <label for="Tomato"> Tomato</label>
    <input type="checkbox" id="Mustard" name="condiment" value="Mustard">
    <label for="Mustard"> Mustard</label>
    <input type="checkbox" id="Sprouts" name="condiment" value="Sprouts">
    <label for="Sprouts"> Sprouts</label>
    <input type="submit" name="SAVE">
</form>
</body>
</html>
