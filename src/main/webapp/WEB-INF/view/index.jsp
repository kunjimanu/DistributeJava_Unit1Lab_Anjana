<%--
  Created by IntelliJ IDEA.
  User: Anjana Menon
  Date: 1/25/2020
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<jsp:include page='header.jsp'/>


<c:url value="/searchBooks" var="actionSearchUrl"/>
<div class="center ">
    <img class="img-container" src="resources/img/bookworm-vector-illustration.jpg">
    <p>For the little booklovers!</p>
</div>

<div class="center">
    <a href="${actionSearchUrl}">Browse our collection</a>
</div>


<jsp:include page='footer.jsp'/>

</body>
</html>
