(function (angular) {
    'use strict';

    angular
        .module('app.shell')
        .config(configureRoutes);

    /** @ngInject */
    function configureRoutes($stateProvider) {
        $stateProvider
            
            .state('main', {
                abstract: true,
                controller: 'MainController',
                controllerAs: 'mainVm',
                templateUrl: 'app/shell/main/main.html'
            })

            .state('doorstep', {
                url: '/',
                templateUrl: 'app/shell/doorstep/doorstep.html'
            })

            .state('notFound', {
                url: '/notFound',
                templateUrl: 'app/shell/notFound/notFound.html'
            })
    }
})(angular);
