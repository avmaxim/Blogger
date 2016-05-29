<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<html >
<head>
    <title>Flogger Home</title>
    <jsp:include page="add-ons/css.jsp"/>
    <meta http-equiv="refresh" content="0;#/">
    <base href="/client-resources/">
</head>
<body ng-app="app">
    <div>
        <div ui-view></div>
    </div>
    <jsp:include page="add-ons/componJS.jsp"/>
    <jsp:include page="add-ons/appJS.jsp"/>
</body>
</html>