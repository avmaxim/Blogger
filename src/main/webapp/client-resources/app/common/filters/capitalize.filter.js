(function (angular) {
    'use strict';

    angular
        .module('app.common')
        .filter('capitalize', function () {
            return function (input) {
                return input ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
            }
        });

})(angular);
