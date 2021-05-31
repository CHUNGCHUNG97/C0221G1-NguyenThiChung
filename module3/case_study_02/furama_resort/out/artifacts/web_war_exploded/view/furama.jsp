<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
            integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
            crossorigin="anonymous"></script>
    <style>
        .logo {

            width: 40px !important;
        }

        .logo:hover {

        }

        .leftMenu {
            padding-left: 20% !important;

        }

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
    <c:choose>
        <c:when test="${type=='home'}">
            <div class="content row mt-1">
                <div class="col-md-12">
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-interval="3000">
                                <img src="https://resortdanang.info/wp-content/uploads/2019/01/resort-furama-da-nang-1024x576.jpg"
                                     class="d-block w-100" alt="..." height="580px">
                            </div>
                            <div class="carousel-item" data-interval="3000">
                                <img src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach.jpg"
                                     class="d-block w-100" alt="..." height="580px">
                            </div>
                            <div class="carousel-item" data-interval="3000">
                                <img src="https://hopefultravel.com.vn/upload/news/canhocondotelfurama2-6514-5155.jpg"
                                     class="d-block w-100" alt="..." height="580px">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button"
                           data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button"
                           data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="content row">
                <div class="col-md-3 border-right">
                    <c:if test="${type=='employee'}">
                        <div class="list-group ">
                            <a href="/employee?action=list" class="list-group-item list-group-item-action">Employee
                                list</a>
                            <a href="/employee?action=create"
                               class="list-group-item list-group-item-action">Create new Employee</a>
                        </div>
                    </c:if>
                    <c:if test="${type=='customer'}">
                        <div class="list-group">
                            <a href="/customer?action=list" class="list-group-item list-group-item-action">Customer
                                list</a>
                            <a href="/customer?action=create"
                               class="list-group-item list-group-item-action">Create
                                new Customer</a>
                        </div>
                    </c:if>
                    <c:if test="${type=='service'}">
                        <div class="list-group">
                            <a href="/service?action=list" class="list-group-item list-group-item-action">Service
                                list</a>
                            <a href="/service?action=create"
                               class="list-group-item list-group-item-action">Create
                                new Service</a>
                        </div>
                    </c:if>
                    <c:if test="${type=='contract'}">
                        <div class="list-group">
                            <a href="/contract?action=list" class="list-group-item list-group-item-action">Contract
                                list</a>
                            <a href="/contract?action=create"
                               class="list-group-item list-group-item-action">Create
                                new Contract</a>
                        </div>
                    </c:if>

                </div>


                <div class="col-md-9">
                    <c:if test="${action=='list' && type=='employee'}">
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
                            <c:forEach var="employee" items="${list}">
                                <tr>

                                    <td>${employee.id}</td>
                                    <td>${employee.fullName}</td>
                                    <td><a href="#">Edit</a></td>
                                    <td>
                                        <button onclick="showModal(${employee.id},'${employee.fullName}','employee')">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${action=='list' && type=='customer'}">
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
                    </c:if>
                    <c:if test="${action=='list' && type=='service'}">
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
                            <c:forEach var="service" items="${list}">
                                <tr>

                                    <td>${service.id}</td>
                                    <td>${service.name}</td>
                                    <td><a href="#">Edit</a></td>
                                    <td>
                                        <button onclick="showModal(${service.id},'${service.name}','service')">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${action=='list' && type=='contract'}">
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
                            <c:forEach var="contract" items="${list}">
                                <tr>

                                    <td>${contract.id}</td>
                                    <td>${contract.name}</td>
                                    <td><a href="#">Edit</a></td>
                                    <td>
                                        <button onclick="showModal(${contract.id},'${contract.name}','contract')">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${action=='create' && type=='employee'}">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Id Product</label>
                            <input type="number" class="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp" name="id">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Name</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" name="name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Price</label>
                            <input type="number" class="form-control" id="exampleInputPassword2" name="price">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Manufacture</label>
                            <input type="text" class="form-control" id="exampleInputPassword3" name="manufacture">
                        </div>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </c:if>
                    <c:if test="${action=='create' && type=='customer'}">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Id Product</label>
                            <input type="number" class="form-control" id="exampleInputEmail2"
                                   aria-describedby="emailHelp" name="id">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Name</label>
                            <input type="text" class="form-control" id="exampleInputPassword4" name="name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Price</label>
                            <input type="number" class="form-control" id="exampleInputPassword5" name="price">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Manufacture</label>
                            <input type="text" class="form-control" id="exampleInputPassword6" name="manufacture">
                        </div>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </c:if>
                    <c:if test="${action=='create' && type=='service'}">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Id Product</label>
                            <input type="number" class="form-control" id="exampleInputEmail3"
                                   aria-describedby="emailHelp" name="id">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Name</label>
                            <input type="text" class="form-control" id="exampleInputPassword7" name="name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Price</label>
                            <input type="number" class="form-control" id="exampleInputPassword8" name="price">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Manufacture</label>
                            <input type="text" class="form-control" id="exampleInputPassword9" name="manufacture">
                        </div>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </c:if>
                    <c:if test="${action=='create' && type=='contract'}">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Id Product</label>
                            <input type="number" class="form-control" id="exampleInputEmail4"
                                   aria-describedby="emailHelp" name="id">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Name</label>
                            <input type="text" class="form-control" id="exampleInputPassword10" name="name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Price</label>
                            <input type="number" class="form-control" id="exampleInputPassword11" name="price">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Manufacture</label>
                            <input type="text" class="form-control" id="exampleInputPassword12" name="manufacture">
                        </div>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </c:if>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
    <div class="footer row  align-items-center bg-success mt-2">
        <div class="col-md-12 d-flex justify-content-center">
            Đặt phòng ngay tại: www.danang.intercontinental.com
        </div>
    </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirm</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="contentModal">
                </div>
                <div class="modal-footer">
                    <a id="hrefDelete" type="button" class="btn btn-primary">OK</a>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>

                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function showModal(id, name, type) {
        document.getElementById("hrefDelete").href = type + "?action=delete&id=" + id;
        document.getElementById("contentModal").innerText = "Are you sure to delete : " + name + " ?";
        var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), null)
        myModal.show();
    }


</script>
</body>
</html>
