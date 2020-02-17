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
        <tr><td>Book id: </td><td><c:out value="${requestScope.currentBook.bookid}" /></td></tr>
        <tr><td>ISBN: </td><td><c:out value="${requestScope.currentBook.isbn}" /></td></tr>
        <tr><td>Title: </td><td><c:out value="${requestScope.currentBook.title}" /></td></tr>
        <tr><td>Category: </td><td><c:out value="${requestScope.currentBook.category}" /></td></tr>
        <tr><td>Author: </td><td><c:out value="${requestScope.currentBookDetail.author}" /></td></tr>
        <tr><td>Publisher: </td><td><c:out value="${requestScope.currentBookDetail.publisher}" /></td></tr>
    </table>
</div>

<jsp:include page='footer.jsp'/>

</body>
</html>
