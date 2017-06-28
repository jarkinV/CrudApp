<%--
  Created by IntelliJ IDEA.
  User: jarki
  Date: 6/17/2017
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/bootstrap.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/login.css" />"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="/login" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Sign in</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><span class="label label-warning">${message}</span></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="login">Login</label>
                    <div class="col-sm-10">
                        <input type="text" name="login" class="form-control" placeholder="Login" id="login">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="password">Password</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" placeholder="Password"
                               id="password">
                    </div>
                </div>
                <div class="col-sm-10 col-sm-offset-2">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>

            </form>

            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus, iusto.

        </div>
    </div>
</div>

</body>
</html>
