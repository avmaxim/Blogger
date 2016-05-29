(function() {
    'use strict';
    
    angular.module("floggerApp", [ "custom", "libraries" ]);

    angular.module("custom", [ "controllers"]);
    angular.module("libraries", [ "ngRoute" ]);
    
    angular.module("controllers",[ 
        "mainControllerModule",
        "loginControllerModule",
        "databaseControllerModule",
        "registerControllerModule"
    ]);    

})();