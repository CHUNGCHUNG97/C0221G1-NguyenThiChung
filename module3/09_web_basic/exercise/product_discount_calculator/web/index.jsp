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
    <input type="text" name="productDescription" size="30" placeholder="product description">
    <input type="text" name="listPrice" size="30" placeholder="list price">
    <input type="text" name="discountPercent" size="30" placeholder="discount percent">
    <input type="submit" value="Calculate Discount">
  </div>
</form>
</body>
</html>
