<%@ page import="com.example.sprinttask2.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="vendor/head.jsp"%>
    <style>
        .content {
            margin-top: 50px;
            margin-left: auto;
            margin-right: auto;
            width: 1000px;
            display: grid;
            gap: 30px;
            grid-template-columns: 1fr 1fr 1fr;
        }

        button {
            background-color: rgb(0,137,79);
            color: white;
            width: 80%;
            margin-top: 30px;
        }

        .cardBlock {
            display:flex;
            flex-direction: column;
            align-items: center;
            border: 1px solid silver;
            border-radius: 5px;
        }


    </style>
</head>
<body style="background-color: rgb(248,249,250)">
    <%@include file="vendor/header.jsp"%>
    <div class="content">
        <%
            ArrayList<Items> items = (ArrayList<Items>) request.getSession().getAttribute("items");

            if(items!=null){
                for(Items i : items){

        %>

            <div class="cardBlock">
                <div class="title" style="padding: 10px; background-color: rgb(237, 237, 237); font-weight: 600; font-size: 1.5em; width: 100%; text-align: center"><%=i.getName()%></div>
                <div style="backround-color:white; text-align: center; padding: 10px 10px 15px 10px" >
                    <div style="color: rgb(0,137,79); font-size: 1.5em; font-weight: 600"><%=i.getPrice()%></div>
                    <p style="margin-top: 10px; height: 50px"><%=i.getDescription()%></p>

                    <button >Buy Now</button>
                </div>
            </div>

        <%
                }
            }
        %>
    </div>
</body>
</html>