<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 26/05/2021
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  PrintWriter writer = response.getWriter();
  Date today = new Date();
  writer.println("<h1>" + today + "</h1>");

  </body>
</html>
