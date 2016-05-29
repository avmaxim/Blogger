<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/client-resources/components/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

<spring:url value="/client-resources/components/bootstrap/dist/css/bootstrap-theme.min.css" var="bootstrapThemeCss" />
<link href="${bootstrapThemeCss}" rel="stylesheet"/>

<spring:url value="/client-resources/application/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" type="text/css"/>
