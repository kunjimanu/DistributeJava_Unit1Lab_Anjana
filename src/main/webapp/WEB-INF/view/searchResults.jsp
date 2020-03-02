<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anjana Menon
  Date: 2/16/2020
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">

</head>
<body>
<jsp:include page='header.jsp'/>
<div class="padding-64">
    <h2 align="center" style="color:black;">Book Details</h2>
    <table class="regulartext" align="center">
        <tr><td><c:out value="${book.bookid}" /></td></tr>
        <tr><td><c:out value="${book.isbn}" /></td></tr>
        <tr><td><c:out value="${book.title}" /></td></tr>
        <tr><td><c:out value="${book.category}" /></td></tr>
    </table>
</div>

<jsp:include page='footer.jsp'/>

</body>
</html>
