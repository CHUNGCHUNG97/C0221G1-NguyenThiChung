<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        img{
            max-height: 200px;
            max-width: 400px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-md-12">
            <h2>Danh sách khách hàng</h2>
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Address</th>
                    <th scope="col">Image</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="customer">
                    <tr>
                        <th scope="row">${customer.name}</th>
                        <td>${customer.birthday}</td>
                        <td>${customer.address}</td>
                        <td><img src="${customer.img}"></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form method="post" action="/customer">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name"></br>
                    <input type="date" class="form-control" name="birthday" placeholder="Birthday"></br>
                    <input type="text" class="form-control" name="address" placeholder="Address"></br>
                    <input type="text" class="form-control" name="img" placeholder="url-img"></br>
                    <input type="submit" value="ADD">
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>
