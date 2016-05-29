(function() {
    'use strict';

    angular
        .module("registerControllerModule", [])
        .controller("registerController", ["urls", registerController]);

    function registerController(urls) {
        var accountCtrl = this;
        accountCtrl.date = new Date();
        accountCtrl.submit = submit;
        var USER_ROLE_HARDCODED_FOR_NOW = "User";

        function submit() {
            var formRegisterData = {
                "email": accountCtrl.user.email,
                "username": accountCtrl.user.name,
                "password": accountCtrl.user.password,
                "role": USER_ROLE_HARDCODED_FOR_NOW
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