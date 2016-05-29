(function (angular) {
    'use strict';

    angular
        .module('app.common')
        .provider('publicApi', function () {
            var provider = this;
            provider.baseUrl = '';
            provider.setBaseUrl = function (url) {
                provider.baseUrl = url;
            };

            provider.$get = publicApi;

            return provider;

            /** @ngInject */
            function publicApi(resourceApiFactory) {
                return resourceApiFactory.create(provider.baseUrl);
            }
        });
})(angular);
