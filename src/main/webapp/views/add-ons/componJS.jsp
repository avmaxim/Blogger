<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/client-resources/bower_components/angular/angular.min.js" var="angularJs" />
    <script src="${angularJs}"></script>

<spring:url value="/client-resources/bower_components/angular-aria/angular-aria.min.js" var="angularAria" />
    <script src="${angularAria}"></script>

<spring:url value="/client-resources/bower_components/angular-animate/angular-animate.min.js" var="angularAnimate" />
    <script src="${angularAnimate}"></script>

<spring:url value="/client-resources/bower_components/angular-material/angular-material.min.js" var="angularMaterial" />
    <script src="${angularMaterial}"></script>

<spring:url value="/client-resources/components/angular-route/angular-route.min.js" var="angularRouteJs" />
    <script src="${angularRouteJs}"></script>