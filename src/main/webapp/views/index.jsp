<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<html >
<head>
    <title>Flogger Home</title>
    <jsp:include page="add-ons/css.jsp"/>
</head>
<body ng-app="floggerApp">
    <div>
        <div ng-view></div>
    </div>
    <jsp:include page="add-ons/componJS.jsp"/>
    <jsp:include page="add-ons/appJS.jsp"/>
</body>
</html>