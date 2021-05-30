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
                            <a class="nav-link" href="/furama?type=home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/furama?type=employee">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/furama?type=customer">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/furama?type=service">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/furama?type=contract">Contract</a>
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
                                <img src="https://hopefultravel.com.vn/upload/news/canhocondotelfurama2-6514-5155.jpg"
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
                            <a href="#" class="list-group-item list-group-item-action">Employee list</a>
                            <a href="#" class="list-group-item list-group-item-action">Create new Employee</a>
                        </div>
                    </c:if>
                    <c:if test="${type=='customer'}">
                        <div class="list-group">
                            <a href="/furama?type=customer&action=list" class="list-group-item list-group-item-action">Customer
                                list</a>
                            <a href="/furama?type=customer&action=create"
                               class="list-group-item list-group-item-action">Create
                                new Customer</a>
                        </div>
                    </c:if>
                    <c:if test="${type=='service'}">
                        <div class="list-group">
                            <a href="/furama?type=service&action=list" class="list-group-item list-group-item-action">Service
                                list</a>
                            <a href="/furama?type=service&action=create"
                               class="list-group-item list-group-item-action">Create
                                new Service</a>
                        </div>
                    </c:if>
                    <c:if test="${type=='contract'}">
                        <div class="list-group">
                            <a href="/furama?type=contract&action=list" class="list-group-item list-group-item-action">Contract
                                list</a>
                            <a href="/furama?type=contract&action=create"
                               class="list-group-item list-group-item-action">Create
                                new Contract</a>
                        </div>
                    </c:if>

                </div>


                <div class="col-md-9">
                    <c:if test="${action=='list' && type=='customer'}">
                        <table class="table table-dark">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            </tbody>
                        </table>
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
</div>


</body>
</html>
