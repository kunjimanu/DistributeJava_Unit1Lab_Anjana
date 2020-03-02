<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>

<body>
<jsp:include page='header.jsp'/>

<div class="padding-64">
    <table style="margin-left:auto;margin-right:auto;">
        <tr>
            <td class="regulartext">Best Item Ever</td>
            <td><img src="../resources/img/pencil.jpg" height="32" width="32"></td>
            <td><img src="../resources/img/bin.jpg" height="32" width="32"></td>
        </tr>
        <tr>
            <td class="regulartext">Worst Item Ever</td>
            <td><img src="../resources/img/pencil.jpg" height="32" width="32"></td>
            <td><img src="../resources/img/bin.jpg" height="32" width="32"></td>
        </tr>
        <tr>
            <td class="regulartext">Kinda okay Item</td>
            <td><img src="../resources/img/pencil.jpg" height="32" width="32"></td>
            <td><img src="../resources/img/bin.jpg" height="32" width="32"></td>
        </tr>
        <tr>
            <td class="regulartext">Strange Item</td>
            <td><img src="../resources/img/pencil.jpg" height="32" width="32"></td>
            <td><img src="../resources/img/bin.jpg" height="32" width="32"></td>
        </tr>
    </table>
</div>
<div class="padding-16">
    <div class="center">
        <a class="btn" href="#">Add Item</a>
    </div>
</div>
<jsp:include page='footer.jsp'/>
</body>
</html>
