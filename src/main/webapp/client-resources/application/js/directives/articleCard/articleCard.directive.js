(function(window) {
    'use strict';

    angular
        .module("custom")
        .directive("articleCard", ["urls", "$http", "$state", "$mdDialog", function (urls) {
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


    function articleCardController(urls, $http, $state, $mdDialog) {
        var vm = this;
        vm.liked = false;
        vm.toggleLike = toggleLike;
        vm.download = download;
        vm.preview = preview;
        vm.removeArticle = removeArticle;

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

        function preview(){
            $state.go('preview-article');
        }

        function removeArticle(){
            $http.post( urls.ARTICLE_DELETEBYID + vm.contents.id)
                .success(function (response, status, headers, config) {
                    $mdDialog.show(
                        $mdDialog.alert()
                            .clickOutsideToClose(true)
                            .title(vm.contents.header)
                            .textContent('Article is successfully removed.')
                            .ariaLabel(vm.contents.header)
                            .ok('Got it!')
                    ).then(function () {
                            $state.go('home');
                    });
                })
                .error(function (response, status, headers, config) {
                    $mdDialog.show(
                        $mdDialog.alert()
                            .clickOutsideToClose(true)
                            .title("Error occured")
                            .textContent("Exception details: " + JSON.stringify({data: response}))
                            .ariaLabel(vm.contents.header)
                            .ok('Got it!')
                    );
                });
        }
    }
})(window);