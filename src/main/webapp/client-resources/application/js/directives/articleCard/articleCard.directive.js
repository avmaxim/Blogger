(function(window) {
    'use strict';

    angular
        .module("custom")
        .directive("articleCard", ["urls", function (urls) {
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
        }]);


    function articleCardController(urls) {
        var vm = this;
        vm.liked = false;
        vm.toggleLike = toggleLike;
        vm.download = download;
        return;

        function toggleLike() {
            vm.liked = !vm.liked;
            if(vm.liked) {
                vm.contents.likesCount++;
            } else {
                vm.contents.likesCount--;
            }
        }
        
        function download(){
            window.open(urls.DOWNLOAD_ARTICLE_PDF + vm.contents.id);
        }
    }
})(window);