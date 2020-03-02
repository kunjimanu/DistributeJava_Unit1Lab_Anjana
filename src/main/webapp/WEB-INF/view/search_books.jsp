<%--
  Created by IntelliJ IDEA.
  User: Anjana Menon
  Date: 2/3/2020
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search books</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<jsp:include page='header.jsp'/>
    <form action="searchresults" method="get">
        <table class="regulartext" align="center">
            <tr>
                <td>Search by bookname <input name="BookName" type="text"></td>
            </tr>
            <br>
            <tr></tr>
            <tr><td><input type="submit"></td></tr>
        </table>
    </form>
<jsp:include page='footer.jsp'/>
</body>
</html>
