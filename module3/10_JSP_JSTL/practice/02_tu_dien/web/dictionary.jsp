<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 27/05/2021
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>
    <c:if test="${result!=null}">
        <c:out value="${result}"/>
    </c:if>
    <c:if test="${result==null}">
        <c:out value="${result}"/>
    </c:if>
</h3>
</body>
</html>
