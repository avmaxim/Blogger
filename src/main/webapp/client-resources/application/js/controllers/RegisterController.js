(function() {
    'use strict';

    angular
        .module("registerControllerModule", [])
        .controller("registerController", ["$http", "urls", registerController]);

    function registerController($http, urls) {
        var accountCtrl = this;
        accountCtrl.date = new Date(Date.now);
        accountCtrl.user = {name: "", password: "", email: ""};
        accountCtrl.submit = submit;

        function submit() {
            var formRegisterData = {
                "email": accountCtrl.user.email,
                "username": accountCtrl.user.name,
                "password": accountCtrl.user.password
            };

            $http
                .post( urls.ACCOUNT_REGISTER, formRegisterData )
                .success(function (response, status, headers, config) {
                    accountCtrl.message = response.data;
                })
                .error(function (response, status, headers, config) {
                    console.error("Exception details: " + JSON.stringify({data: response}));
                });
        }
        // ur code goes here too;
    }
})();