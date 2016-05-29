<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/client-resources/components/angular/angular.min.js" var="angularJs" />
    <script src="${angularJs}"></script>

<spring:url value="/client-resources/components/angular-route/angular-route.min.js" var="angularRouteJs" />
    <script src="${angularRouteJs}"></script>

<spring:url value="/client-resources/components/jquery/dist/jquery.js" var="jqueryJs" />
    <script src="${jqueryJs}"></script>

<spring:url value="/client-resources/components/bootstrap/dist/js/bootstrap.js" var="bootstrapJs" />
    <script src="${bootstrapJs}"></script>