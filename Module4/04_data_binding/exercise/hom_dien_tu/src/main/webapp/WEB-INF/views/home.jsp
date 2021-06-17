<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 16/06/2021
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="mail" method="post" modelAttribute="mail">
    <table>
        <tr>
            <td><form:label path="language">Language </form:label></td>

            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size</form:label></td>
            <td>
                <form:select path="pageSize">
                    <form:options items="${pageSizes}"/>
                </form:select>
                <form:label path="pageSize">emails per page</form:label>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spam filter</form:label></td>
            <td>
                <form:checkbox path="spamFilter"/>
                <form:label path="spamFilter">Enable spams filter</form:label>
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input style="background:#0f86ff" type="submit" value="Update"></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form:form>


</body>
</html>
