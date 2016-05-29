<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/client-resources/bower_components/angular-material/angular-material.min.css" var="indexCss" />
    <link href="${indexCss}" rel="stylesheet" />

<spring:url value="/client-resources/application/styles/css/index.css" var="indexCss" />
    <link href="${indexCss}" rel="stylesheet" />
