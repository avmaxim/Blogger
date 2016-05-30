(function() {
    'use strict';

    angular
        .module("custom")
        .directive("articleCard", function () {
            return {
                restrict: 'E',
                controller: articleCardController,
                controllerAs: 'articleVm',
                templateUrl: '/client-resources/application/js/directives/articleCard/article-card.html',
                scope: {
                    contents: '='
                },
                bindToController: true
            };
        });


    function articleCardController() {
        var vm = this;
        vm.liked = false;
        vm.toggleLike = toggleLike;
        return;

        function toggleLike() {
            vm.liked = !vm.liked;
            if(vm.liked) {
                vm.contents.likesCount++;
            } else {
                vm.contents.likesCount--;
            }
        }
    }
})();