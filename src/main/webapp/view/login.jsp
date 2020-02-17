<%--
  Created by IntelliJ IDEA.
  User: Anjana Menon
  Date: 1/22/2020
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">

</head>
<body>
    <jsp:include page='header.jsp'/>
    <div class="center">
        <h2>Login to our store!</h2>
        <p >Username:<input class="padding-4" type="text" placeholder="Username"></p>
        <p >Password:<input class="padding-4" type="text" placeholder="Password"></p>
        <a class="btn" href="#">Login</a>
    </div>
    <jsp:include page='footer.jsp'/>
</body>
</html>
