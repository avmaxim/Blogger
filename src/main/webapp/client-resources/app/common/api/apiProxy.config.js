(function (angular) {
    'use strict';

    angular
        .module('app.common')
        .config(configure);

    function configure(publicApiProvider, configuration) {
        publicApiProvider.setBaseUrl(configuration.publicApiEndpoint);
    }
})(angular);