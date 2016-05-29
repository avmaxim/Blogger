(function (angular) {

    angular.module('app.common.configuration', [])

        .constant('configuration', {
            'publicApiEndpoint': 'localhost:9999'
        });

})(angular);
