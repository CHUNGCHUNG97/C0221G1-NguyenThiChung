<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 28/05/2021
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-md-12">
            <h2>Danh sách khách hàng</h2>
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <th scope="row">${customer.id}</th>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.address}</td>
                        <td><a href="customer?action=edit&id=${customer.id}">Edit</a></td>
                        <td><a href="customer?action=delete&id=${customer.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form method="post" action="/customer">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Id"></br>
                    <input type="date" class="form-control" name="birthday" placeholder="Name"></br>
                    <input type="text" class="form-control" name="address" placeholder="Email"></br>
                    <input type="text" class="form-control" name="img" placeholder="Address"></br>
                    <input type="submit" value="ADD">
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>
