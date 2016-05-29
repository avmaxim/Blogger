<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/client-resources/bower_components/angular-material/angular-material.min.css" var="materialCss" />
    <link href="${materialCss}" rel="stylesheet" />

<spring:url value="/client-resources/dist/bundle.css" var="bundleCss" />
    <link href="${bundleCss}" rel="stylesheet" />
