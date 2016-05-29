(function (angular) {
    'use strict';

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
