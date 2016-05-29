<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/client-resources/application/js/app.js" var="appJs" />
    <script src="${appJs}"></script>
<spring:url value="/client-resources/application/js/urls.js" var="urlsJs" />
    <script src="${urlsJs}"></script>
<spring:url value="/client-resources/application/js/controllers/MainController.js" var="appMainControllerJs" />
    <script src="${appMainControllerJs}"></script>
<spring:url value="/client-resources/application/js/controllers/LoginController.js" var="appLoginControllerJs" />
    <script src="${appLoginControllerJs}"></script>
<spring:url value="/client-resources/application/js/controllers/DatabaseController.js" var="appDatabaseControllerJs" />
    <script src="${appDatabaseControllerJs}"></script>
<spring:url value="/client-resources/application/js/controllers/RegisterController.js" var="appRegisterControllerJs" />
    <script src="${appRegisterControllerJs}"></script>
<spring:url value="/client-resources/application/js/routes.js" var="appRoutesJs" />
    <script src="${appRoutesJs}"></script>