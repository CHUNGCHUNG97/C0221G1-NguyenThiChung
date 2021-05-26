<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .submit {
            height:200px; width:300px;
            margin:0;
            padding:10px;

        }
        .submit input {
            padding:5px; margin:5px;
            height: 50px;
            width: 300px;
        }
    </style>
</head>
<body>
<form method="post" action="/display-discount">
    <div class="submit">
    <input type="text" name="product description" size="30" placeholder="product description">
    <input type="text" name="list price" size="30" placeholder="list price">
    <input type="text" name="discount percent" size="30" placeholder="discount percent">
    <input type="submit" name="Calculate Discount">
    </div>
</form>
</body>
</html>
