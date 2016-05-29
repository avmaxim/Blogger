(function (angular) {
    'use strict';

    angular
        .module('app.shell')
        .factory('shellService', shellService);

    /** @ngInject */
    function shellService() {

        var contentProgressShown = false;

        return {
            showContentProgress: showContentProgress,
            hideContentProgress: hideContentProgress,
            isContentProgressShown: isContentProgressShown
        };

        function showContentProgress() {
            contentProgressShown = true;
        }

        function hideContentProgress() {
            contentProgressShown = false;
        }

        function isContentProgressShown() {
            return contentProgressShown;
        }
    }

})(angular);
