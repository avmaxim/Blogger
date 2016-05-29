(function (angular) {
    'use strict';

    angular
        .module('app.common')
        .factory('resourceApiFactory', resourceApiFactory);

    /** @ngInject */
    function resourceApiFactory($resource) {

        return {
            create: create
        };

        function create(baseUrl) {
            return function resourceApi(url, paramDefaults, actions, options) {
                var decoratedUrl = baseUrl + '/' + url;
                return $resource(decoratedUrl, paramDefaults, actions, options);
            }
        }
    }

})(angular);
