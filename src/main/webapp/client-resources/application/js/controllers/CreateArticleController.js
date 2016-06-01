(function() {
    'use strict';

    angular
        .module("createArticleControllerModule", [])
        .controller("createArticleController", ["$http", "urls", "$state", "$mdDialog", createArticleController]);

    function createArticleController($http, urls, $state, $mdDialog) {
        var vm = this;
        vm.contents = {id:"0", header: "", contents: "", date: "", likesCount: "0", ownerId:"0"};
        vm.createArticle = function(){
			$http.post(urls.ARTICLE_SAVE, vm.contents)
			.success(function(response, status, headers, config){
                $mdDialog.show(
                    $mdDialog.alert()
                        .clickOutsideToClose(true)
                        .title(vm.contents.header)
                        .textContent('Article is successfully created.')
                        .ariaLabel(vm.contents.header)
                        .ok('Got it!')
                ).then(function () {
                    $state.go('home');
                });
			})
			.error(function(){
				
			})
		}
        // ur code goes here too;
    }
})();