<%--
  Created by IntelliJ IDEA.
  User: jarki
  Date: 6/18/2017
  Time: 2:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manage</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/bootstrap.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/login.css" />"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped">

                <tr>
                    <th>Id</th>
                    <th>Login</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>Role</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.userId}</td>
                        <td>${u.login}</td>
                        <td>${u.name}</td>
                        <td>${u.age}</td>
                        <td>${u.address}</td>
                        <td>${u.role}</td>
                        <td><button class="removeUser" data-userId="${u.userId}">❌</button></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value="resources/ajaxQueries.js" />"></script>
</body>
</html>
