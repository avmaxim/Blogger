(function () {
    'use strict';

    angular.module("floggerApp")

        .config(function ($stateProvider, $urlRouterProvider, urls) {
            $stateProvider

                .state("main", {
                    url: '',
                    templateUrl: "/client-resources/application/html/main.html",
                    controller: "mainController",
                    controllerAs: "mainCtrl"
                })

                .state("login", {
                    url: '/login',
                    templateUrl: "/client-resources/application/html/login.html",
                    controller: "loginController",
                    controllerAs: "loginCtrl"
                })

                .state("register", {
                    url: '/register',
                    templateUrl: "/client-resources/application/html/register.html",
                    controller: "registerController",
                    controllerAs: "accountCtrl"
                })

                .state("entities", {
                    urls: '/entities',
                    templateUrl: "/client-resources/application/html/database-demo.html",
                    controller: "databaseController",
                    controllerAs: "dbCtrl"
                })

                .state("preview-article", {
                    urls: '/preview-article',
                    templateUrl: "/client-resources/application/html/preview-article.html",
                    controller: "previewArticleController",
                    controllerAs: "previewACtrl"
                })
                .state("create-article", {
                    urls: '/create-article',
                    templateUrl: "/client-resources/application/html/create-article.html",
                    controller: "createArticleController",
                    controllerAs: "createACtrl"
                })
                .state("home", {
                    url: '/home',
                    templateUrl: "/client-resources/application/html/home.html",
                    controller: "homeController",
                    controllerAs: "homeCtrl",
                    resolve: {
                        allArticles: function ($http) {
                            return $http.get(urls.ARTICLES_GET_ALL);
                        },
                        urls: function(){
                            return urls;
                        }
                    }
                });
            $urlRouterProvider.otherwise('/');
        });
})();