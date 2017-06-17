<%--
  Created by IntelliJ IDEA.
  User: jarki
  Date: 6/17/2017
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/bootstrap.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/login.css" />"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="page-header">
                <h1>Hello ${user.name} <small><a href="#"><span class="badge">edit</span></a></small></h1>
            </div>

        </div>
        <div class="col-md-8 col-md-offset-2">
            <dl class="dl-horizontal">
                <dt>Age</dt>
                <dd>${user.age}</dd>
                <dt>Address</dt>
                <dd>${user.address}</dd>
            </dl>

        </div>
    </div>
</div>
     <!-- You can use the c:out if you really want to -->

</body>
</html>
