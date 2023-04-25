<%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/25/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
    <%@include file="vendor/header.jsp"%>

    <%
        String error = request.getParameter("error");
        if(error!=null){




    %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert" style="width: 60%; margin-left: auto; margin-right: auto;">
            Incorrect <strong>email</strong> and <strong>password</strong>

        </div>
    <%
        }
    %>
    <form action="/LoginServlet" method="post" style="width: 60%; margin-left: auto; margin-right: auto; margin-top: 50px">
        <div class="form-group row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control-plaintext" id="staticEmail" name="email" placeholder="Email">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
            </div>
        </div>
        <button class="btn btn-success" style="margin-top: 10px">Success</button>
    </form>
</body>
</html>
