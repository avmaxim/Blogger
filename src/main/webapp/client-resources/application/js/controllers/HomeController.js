(function(window) {
    'use strict';

    angular
        .module("homeControllerModule", [])
        .controller("homeController", homeController);

    
    function homeController(allArticles, urls) {
        var homeCtrl = this;
        homeCtrl.allArticles = allArticles.data.data;
        homeCtrl.downloadArticlesExcel = downloadArticlesExcel;
        return;
        
        function downloadArticlesExcel(){
            window.open(urls.DOWNLOAD_ARTICLES_EXCEL);
            window.open(urls.DOWNLOAD_ARTICLES_CSV);
        }

      
    }
})(window);