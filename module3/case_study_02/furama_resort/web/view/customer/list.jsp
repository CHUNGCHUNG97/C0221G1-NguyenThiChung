<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 31/05/2021
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        .myheader {
            height: 10vh !important;
        }

        .content {
            height: 80vh !important;
            margin-top: 14px !important;
        }

        .footer {
            height: 6vh !important;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="myheader row" style="padding-bottom: 0px!important;">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <img src="https://phuongviethcm.com/wp-content/uploads/2019/07/FURAMA.png"
                     class="circular rounded mx-auto d-block" alt="..." style="width: 40px">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/service">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/contract">Contract</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div class="content row">
        <div class="col-md-3 border-right">
            <div class="list-group">
                <a href="/customer?action=list" class="list-group-item list-group-item-action">Customer
                    list</a>
                <a href="/customer?action=create"
                   class="list-group-item list-group-item-action">Create
                    new Customer</a>
            </div>
        </div>
        <div class="col-md-9">
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${list}">
                    <tr>

                        <td>${customer.id}</td>
                        <td>${customer.fullName}</td>
                        <td><a href="#">Edit</a></td>
                        <td>
                            <button onclick="showModal(${customer.id},'${customer.fullName}','customer')">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="footer row  align-items-center bg-success mt-2">
    <div class="col-md-12 d-flex justify-content-center">
        Đặt phòng ngay tại: www.danang.intercontinental.com
    </div>
</div>
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
