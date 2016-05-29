(function() {
    'use strict';

    angular
        .module("databaseControllerModule", [])
        .controller("databaseController", ["$http", "urls", databaseController]);

    function databaseController($http, urls) {
        var dbCtrl = this;
        dbCtrl.users = [];
        dbCtrl.articles = [];
        
        dbCtrl.fetchAllUsers = function() {
            $http
                .get(urls.USERS_SHOWUP)
                .success(function(response, status, headers, config){
                    dbCtrl.users = response.data;
                })
                .error(function (response, status, headers, config) {
                    console.error("Exception details: " + JSON.stringify({data: response}));
                })
        };
        
        dbCtrl.fetchAllArticles = function() {
            $http
                .get(urls.ARTICLES_SHOWUP)
                .success(function(response, status, headers, config){
                    dbCtrl.articles = response.data;
                })
                .error(function (response, status, headers, config) {
                    console.error("Exception details: " + JSON.stringify({data: response}));
                })
        };

        dbCtrl.fetchAllUsers();
       // dbCtrl.fetchAllArticles();
    }
})();