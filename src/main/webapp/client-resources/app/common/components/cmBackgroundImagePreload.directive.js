(function (angular) {
    'use strict';

    angular
        .module('app.common')
        .directive('cmBackgroundImagePreload', cmBackgroundImagePreload);

    /** @ngInject */
    function cmBackgroundImagePreload($compile) {

        return {
            restrict: 'A',
            scope: {
                imageToLoad: '=cmBackgroundImagePreload',
                fallbackImage: '='
            },
            template: '<md-progress-circular ng-if="inProgress" md-mode="indeterminate"></md-progress-circular>',
            link: function (scope, element) {
                element.css('background-size', 'cover');
                var img, loadImage;
                img = null;

                loadImage = function () {

                    img = new Image();
                    img.src = scope.imageToLoad;
                    inProgress(true);

                    img.onload = function () {
                        setBackgroundImage(scope.imageToLoad);
                        inProgress(false);
                    };
                    img.onerror = function () {
                        setBackgroundImage(scope.fallbackImage);
                        inProgress(false);
                    }
                };

                loadImage();

                function setBackgroundImage(imageUrl) {
                    element.css('background-image', 'url(' + imageUrl + ')')
                }


                function inProgress(isInProgress) {
                    scope.inProgress = isInProgress;
                    updateTemplate();
                }

                function updateTemplate() {
                    $compile(element.contents())(scope);
                }
            }
        };

    }

})(angular);
