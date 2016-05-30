(function() {
    'use strict';

    angular
        .module("loginControllerModule", [])
        .controller("loginController", ["$http", "$state", "urls", loginController]);

    function loginController($http, $state, urls) {
            var loginCtrl = this;
            loginCtrl.message = "";
            loginCtrl.user = {name: "", password: ""};
            loginCtrl.submit = submit;
                
            function submit() {
                var formLoginData = {
                    "username": loginCtrl.user.name,
                    "password": loginCtrl.user.password
                };

               $http
                    .post( urls.ACCOUNT_LOGIN, formLoginData )
                    .success(function (response, status, headers, config) {
                        loginCtrl.message = response.data;
                        $state.go('home');
                    })
                    .error(function (response, status, headers, config) {
                        console.error("Exception details: " + JSON.stringify({data: response}));
                    });
            }
    }
})();