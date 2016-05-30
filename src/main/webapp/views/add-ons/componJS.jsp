<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/client-resources/bower_components/angular/angular.min.js" var="angularJs" />
    <script src="${angularJs}"></script>

<spring:url value="/client-resources/bower_components/angular-aria/angular-aria.min.js" var="angularAria" />
    <script src="${angularAria}"></script>

<spring:url value="/client-resources/bower_components/angular-animate/angular-animate.min.js" var="angularAnimate" />
    <script src="${angularAnimate}"></script>

<spring:url value="/client-resources/bower_components/angular-material/angular-material.min.js" var="angularMaterial" />
    <script src="${angularMaterial}"></script>

<spring:url value="/client-resources/bower_components/angular-messages/angular-messages.min.js" var="angularMessages" />
    <script src="${angularMessages}"></script>

<spring:url value="/client-resources/bower_components/angular-toastr/dist/angular-toastr.min.js" var="angularToastr" />
    <script src="${angularToastr}"></script>

<spring:url value="/client-resources/bower_components/angular-ui-router/release/angular-ui-router.min.js" var="uiRouterJs" />
    <script src="${uiRouterJs}"></script>