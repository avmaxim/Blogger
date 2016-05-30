(function() {
    'use strict';

    angular
        .module("registerControllerModule", [])
        .controller("registerController", ["$http", "urls", "$mdDialog", "$state", registerController]);

    function registerController($http, urls, $mdDialog, $state) {
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
                    $mdDialog.show(
                        $mdDialog.alert()
                            .clickOutsideToClose(true)
                            .title('This is an alert title')
                            .textContent('You are registered successfully. You\'ll be redirect to the login page.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('Got it!')
                    ).then(function () {
                        $state.go('login');
                    });
                })
                .error(function (response, status, headers, config) {
                    console.error("Exception details: " + JSON.stringify({data: response}));
                });
        }
        // ur code goes here too;
    }
})();