<!DOCTYPE html>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<html>
    <head>
        <title>Flogger Home</title>
    </head>

    <body>
        <div style="text-align: center; margin-top: 100px">
            <h1>Hi there from Flogger =)</h1>
            <h3 style="color: green"> Date: <%= new Date() %> </h3>
            <h4 >Go to <a  href="/views/login.jsp">Login Page</a></h4>
        </div>
    </body>

</html>