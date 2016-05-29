(function (angular) {
    'use strict';

    angular
        .module('app')
        .config(configureRoutes);

    /** @ngInject */
    function configureRoutes($urlRouterProvider) {
        $urlRouterProvider.otherwise('/notFound');
    }
})(angular);
