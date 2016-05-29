(function (angular) {
    'use strict';

    angular.module('app')
        .run(run);

    /** @ngInject */
    function run ($location, $state, $rootScope, shellService) {

        var deregisterStateChangeStart = $rootScope.$on('$stateChangeStart',
            function(){
                shellService.showContentProgress();
            });

        var deregisterStateChangeSuccess = $rootScope.$on('$stateChangeSuccess',
            function(){
                shellService.hideContentProgress();
            });

        var deregisterStateChangeError = $rootScope.$on('$stateChangeError',
            function(){
                $state.go('notFound', null, {location: 'replace'});
            });

        $rootScope.$on('$destroy',
            function(){
                deregisterStateChangeStart();
                deregisterStateChangeSuccess();
                deregisterStateChangeError();
            });
    }
})(angular);
