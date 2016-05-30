(function () {
    'use strict';

    angular.module("floggerApp", ["custom", "libraries"]);

    angular.module("custom", ["controllers", "services"]);
    angular.module("libraries", ["ui.router", 'ngMessages', 'ngAria', 'ngMaterial', 'toastr']);

    angular.module("controllers", [
        "mainControllerModule",
        "loginControllerModule",
        "databaseControllerModule",
        "registerControllerModule",
        "articlesControllerModule"
    ]);

    angular.module("services", [
        "userServiceModule"
    ]);

})();