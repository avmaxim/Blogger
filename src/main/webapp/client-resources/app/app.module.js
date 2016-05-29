(function (angular) {
    'use strict';

    angular.module('app', [
        //vendor dependencies
        'ngAnimate',
        'ngCookies',
        'ngMessages',
        'ngAria',
        'ngResource',
        'ui.router',
        'ngMaterial',
        'toastr',
        //app modules go here
        'app.common',
        'app.shell'
    ]);

})(angular);
