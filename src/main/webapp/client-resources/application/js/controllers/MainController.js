(function() {
    'use strict';

    angular
        .module("mainControllerModule", [])
        .controller("mainController", [mainController]);
    
    function mainController() {
        var mainCtrl = this;
        mainCtrl.date = new Date();
        // ur code goes here too;
    }
})();