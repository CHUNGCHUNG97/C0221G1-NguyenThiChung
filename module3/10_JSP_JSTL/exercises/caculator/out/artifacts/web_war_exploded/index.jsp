<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/calculator">
    <div class="container">
        <div class="row">
            <div class="col-lg-5 ">

                <h1 class="text-center">Calculator</h1>
                <label>First operand <input type="text" name="first" class="ml-4"></label>
                <div class="text-center">
                    <select name="select">
                        <option value="sum">summation</option>
                        <option value="sub">subtraction</option>
                        <option value="mul">multiplication</option>
                        <option value="div">division</option>
                    </select>
                </div>
                <label class="mt-2">Second operand <input type="text" name="second"></label><br>
                <div class="text-center"><input type="submit" value="calculator"></div>

            </div>
        </div>
    </div>
</form>
</body>
</html>
