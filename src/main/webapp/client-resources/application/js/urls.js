(function (window) {
    "use strict";

    var FLOGGER_HOST_URL = window.location.protocol + "//" + window.location.host;

    var ROUTE_URLS = {
        ACCOUNT_LOGIN: FLOGGER_HOST_URL + "/account/login",
        ACCOUNT_REGISTER: FLOGGER_HOST_URL + "/account/register",
        USERS_SHOWUP: FLOGGER_HOST_URL + "/entities/users",
        ARTICLES_SHOWUP: FLOGGER_HOST_URL + "/entities/articles",
        ARTICLES_GET_ALL: FLOGGER_HOST_URL + "/article/getAll",
        DOWNLOAD_ARTICLE_PDF: FLOGGER_HOST_URL + "/document/downloadArticleAsPDF/",
        DOWNLOAD_ARTICLES_EXCEL: FLOGGER_HOST_URL + "/document/downloadArticlesAsExcel"
    };

    angular.module("floggerApp").constant("urls", ROUTE_URLS);
    
})(window);