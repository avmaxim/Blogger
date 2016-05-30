(function() {
    'use strict';

    angular
        .module("articlesControllerModule", [])
        .controller("articlesController", articlesController);


    articlesController.$inject = ["$http", "urls"];
    
    function articlesController($http, urls) {
        var artCtrl = this;
        
    }
})();