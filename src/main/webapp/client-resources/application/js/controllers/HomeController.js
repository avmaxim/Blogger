(function() {
    'use strict';

    angular
        .module("homeControllerModule", [])
        .controller("homeController", homeController);

    
    function homeController(allArticles) {
        var artCtrl = this;
        artCtrl.allArticles = allArticles.data.data;
    }
})();