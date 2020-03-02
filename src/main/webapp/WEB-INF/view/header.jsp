<%--
  Created by IntelliJ IDEA.
  User: Anjana Menon
  Date: 2/16/2020
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>BOOKWORM</h1>
    <c:url value="/login" var="actionLoginUrl"/>

    <div class="right">
        <a href="${actionLoginUrl}" style="color:white">Login</a>
    </div>
</header>
