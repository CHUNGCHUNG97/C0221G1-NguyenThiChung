<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 28/05/2021
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/customer?action=edit">
    <h2>${mes}</h2>
    <div class="form-row">
        <div class="col-md-12 mt-3">
            <label for="validationDefault01">Id</label>
            <input type="text" class="form-control" id="validationDefault01" name="id" value="${customer.id}" required readonly>
        </div>
    </div>
    <div class="form-row">
        <div class="col-md-12 mt-3">
            <label for="validationDefault02">Name</label>
            <input type="text" class="form-control" id="validationDefault02" name="name" value="${customer.name}" required>
        </div>
    </div>
    <div class="form-row">
        <div class="col-md-12 mt-3">
            <label for="validationDefault01">Email</label>
            <input type="text" class="form-control" id="validationDefault03" name="email" value="${customer.email}"
                   required>
        </div>
    </div>
    <div class="form-row">
        <div class="col-md-12 mt-3">
            <label for="validationDefault02">Address</label>
            <input type="text" class="form-control" id="validationDefault04" name="address" value="${customer.address}" required>
        </div>
    </div>
    <input type="submit" value="edit">
</form>
</body>
</html>
