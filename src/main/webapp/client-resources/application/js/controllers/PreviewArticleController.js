(function() {
    'use strict';

    angular
        .module("previewArticleControllerModule", [])
        .controller("previewArticleController", ["urls", previewArticleController]);

    function previewArticleController(urls) {
        var previewACtrl = this;
        previewACtrl.date = new Date();
        // ur code goes here too;
    }
})();