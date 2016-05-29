(function() {
    'use strict';

    angular.module("floggerApp")

        .config(function ($routeProvider) {
            $routeProvider

                .when("/", {
                    templateUrl: "/client-resources/application/html/main.html",
                    controller: "mainController",
                    controllerAs: "mainCtrl"
                })

                .when("/login", {
                    templateUrl: "/client-resources/application/html/login.html",
                    controller: "loginController",
                    controllerAs: "loginCtrl"
                })

                .when("/register", {
                    templateUrl: "/client-resources/application/html/register.html",
                    controller: "registerController",
                    controllerAs: "accountCtrl"
                })
                
                .when("/entities", {
                    templateUrl: "/client-resources/application/html/database-demo.html",
                    controller: "databaseController",
                    controllerAs: "dbCtrl"
                })
                                
                .otherwise({
                    redirectTo: "/"
                });
        });
})();