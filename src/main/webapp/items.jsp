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
                <h1>Hello ${user.name}
                    <button type="button" id="buttonAddItem" class="btn btn-primary btn-lg" data-toggle="modal"
                            data-target="#myModal">
                        Add Item
                    </button>
                </h1>
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

                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.text}</td>


                        <td><button  class="itemState" data-itemId="${item.itemId}">${item.state?"✔":"❌"}</button></td>


                        <form action="/removeItem" method="post">
                            <input type="hidden" name="itemId" value="${item.itemId}">
                            <td><input type="submit" class="buttonId" value="🔥"></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Add Item</h4>
            </div>
            <form action="/addItem" method="post" class="form-horizontal">
                <div class="modal-body">


                    <div class="form-group">
                        <label class="col-sm-1 control-label" for="text">Text</label>
                        <div class="col-sm-11">
                            <input type="text" name="text" class="form-control" placeholder="Text" id="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" id="labelCheckbox" for="text">State</label>
                        <div class="col-sm-11">
                            <label class="labelDone">
                                <input type="checkbox" value="check" name="check">
                                Done!
                            </label>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value="resources/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="resources/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="resources/ajaxQueries.js" />"></script>
</body>
</html>
