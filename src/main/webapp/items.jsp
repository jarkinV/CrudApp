<%--
  Created by IntelliJ IDEA.
  User: jarki
  Date: 6/17/2017
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Items</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/bootstrap.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/login.css" />"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="page-header">
                <h1>Hello ${user.name}</h1>
            </div>

        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-striped">

                <tr>
                    <th>Text</th>
                    <th>State</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items="${list}" var="item" >
                <tr>
                <td>${item.text}</td>
                <td>${item.state?"✔":"❌"}</td>
                <td>🔥</td>
                </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

</body>
</html>
