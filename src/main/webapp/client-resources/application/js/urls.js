(function (window) {
    "use strict";

    var FLOGGER_HOST_URL = window.location.protocol + "//" + window.location.host;

    var ROUTE_URLS = {
        ACCOUNT_LOGIN: FLOGGER_HOST_URL + "/account/login",
        ACCOUNT_REGISTER: FLOGGER_HOST_URL + "/account/register",
        USERS_SHOWUP: FLOGGER_HOST_URL + "/entities/users",
        ARTICLES_SHOWUP: FLOGGER_HOST_URL + "/entities/articles",
        ARTICLES_GET_ALL: FLOGGER_HOST_URL + "/article/getAll",
        ARTICLE_GETBYID: FLOGGER_HOST_URL + "/article/getById/",
        ARTICLE_SAVE: FLOGGER_HOST_URL + "/article/save",
        ARTICLE_UPDATE: FLOGGER_HOST_URL + "/article/update",
        ARTICLE_DELETEBYID: FLOGGER_HOST_URL + "/article/deleteById/",
        DOWNLOAD_ARTICLE_PDF: FLOGGER_HOST_URL + "/document/downloadArticleAsPDF/",
        DOWNLOAD_ARTICLES_EXCEL: FLOGGER_HOST_URL + "/document/downloadArticlesAsExcel",
        DOWNLOAD_ARTICLES_CSV: FLOGGER_HOST_URL + "/document/downloadArticlesAsCSV"
    };

    angular.module("floggerApp").constant("urls", ROUTE_URLS);
    
})(window);