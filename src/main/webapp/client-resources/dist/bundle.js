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

(function (angular) {
    'use strict';

    angular.module('app.common', [
        'app.common.configuration'
    ]);
})(angular);


(function (angular) {
    'use strict';

    angular
        .module('app.shell', [
            'app.common'
        ]);

})(angular);

(function (angular) {
    'use strict';

    config.$inject = ["$logProvider", "$locationProvider", "toastrConfig"];
    angular
        .module('app')
        .config(config);

    /** @ngInject */
    function config($logProvider, $locationProvider, toastrConfig) {
        // Enable log
        $logProvider.debugEnabled(true);

        // Set options third-party lib
        toastrConfig.allowHtml = true;
        toastrConfig.timeOut = 3000;
        toastrConfig.positionClass = 'toast-top-right';
        toastrConfig.preventDuplicates = true;
        toastrConfig.progressBar = true;
        
    }

})(angular);

(function (angular) {
    'use strict';

    configureRoutes.$inject = ["$urlRouterProvider"];
    angular
        .module('app')
        .config(configureRoutes);

    /** @ngInject */
    function configureRoutes($urlRouterProvider) {
        $urlRouterProvider.otherwise('/notFound');
    }
})(angular);

(function (angular) {
    'use strict';

    run.$inject = ["$location", "$state", "$rootScope", "shellService"];
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

(function (angular) {

    angular.module('app.common.configuration', [])

        .constant('configuration', {
            'publicApiEndpoint': 'localhost:9999'
        });

})(angular);

(function (angular) {
    'use strict';

    configureRoutes.$inject = ["$stateProvider"];
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

(function (angular) {
    'use strict';

    configure.$inject = ["publicApiProvider", "configuration"];
    angular
        .module('app.common')
        .config(configure);

    function configure(publicApiProvider, configuration) {
        publicApiProvider.setBaseUrl(configuration.publicApiEndpoint);
    }
})(angular);
(function (angular) {
    'use strict';

    angular
        .module('app.common')
        .provider('publicApi', function () {
            publicApi.$inject = ["resourceApiFactory"];
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

(function (angular) {
    'use strict';

    resourceApiFactory.$inject = ["$resource"];
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

(function (angular) {
    'use strict';

    angular
        .module('app.common')
        .filter('capitalize', function () {
            return function (input) {
                return input ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
            }
        });

})(angular);

(function (angular) {
    'use strict';

    cmBackgroundImagePreload.$inject = ["$compile"];
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


(function (angular) {
    'use strict';

    MainController.$inject = ["shellService"];
    angular
        .module('app.shell')
        .controller('MainController', MainController);

    /** @ngInject */
    function MainController(shellService) {
        var vm = this;
        vm.isContentProgressShown = shellService.isContentProgressShown;

        return;

    }
})(angular);

