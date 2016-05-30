(function() {
    'use strict';

    angular
        .module("userServiceModule", [])
        .factory("userService", userService);

    userService.$inject = [];
    
    function userService() {
        
        return {
            
        };
    }
})();