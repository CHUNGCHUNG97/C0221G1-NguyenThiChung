<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 28/05/2021
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-md-12">
            <h2>Danh sách sản phẩm</h2>
            <a href="product?action=add">
                <button type="button" class="btn btn-primary">Add Product</button>
            </a>
            <form method="get" action="/product">
                <input type="text" name="name" placeholder="search name product">
                <input type="text" name="action" value="search" hidden>
                <input type="submit" value="name">
            </form>
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Manufacture</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <th scope="row">${product.id}</th>
                        <td>${product.name}</td>
                        <td><fmt:formatNumber value="${product.price}" type="number"/> vnd</td>
                        <td>${product.manufacture}</td>
                        <td><a href="product?action=edit&id=${product.id}">Edit</a></td>
                        <td>
                            <button onclick="showModal(${product.id},'${product.name}')">Remove</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div id="modal"></div>
</div>


<script>
    function showModal(i, name) {
        const modalHtml = "<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
            "  <div class=\"modal-dialog\">\n" +
            "    <div class=\"modal-content\">\n" +
            "      <div class=\"modal-body\">\n" +
            "        <p>Are you sure product: " + name + "?</p>\n" +
            "      </div>\n" +
            "      <div class=\"modal-footer\">\n" +
            "        <a type=\"button\" class=\"btn btn-primary\" href=\"product?action=remove&id=" + i + "\">Ok</a>\n" +
            "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancel</button>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</div>"
        document.getElementById("modal").innerHTML = modalHtml;
        var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), null)
        myModal.show();
    }


</script>
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
