app.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider){
    
    $urlRouterProvider
						.otherwise('/home');
    
    var home = {
        templateUrl : "/views/home.html",
        url : "/home",
        controller : "homeController",
        controllerAs : "home",
        resolve : {
            deps : ["$ocLazyLoad", function($ocLazyLoad){
                return $ocLazyLoad.load({
                    serie: true,
                    files: [
                        "controllers/homeController.js"
                    ]
                });
            }] 
        }
    }

    var sacar = {
        templateUrl : "/views/sacar.html",
        url : "/sacar/:id",
        controller : "sacarController",
        controllerAs : "sacar",
        resolve : {
            deps : ["$ocLazyLoad", function($ocLazyLoad){
                return $ocLazyLoad.load({
                    serie: true,
                    files: [
                        "controllers/sacarController.js"
                    ]
                });
            }] 
        }
    }

    var criar = {
        templateUrl : "/views/criar.html",
        url : "/criar",
        controller : "criarController",
        controllerAs : "criar",
        resolve : {
            deps : ["$ocLazyLoad", function($ocLazyLoad){
                return $ocLazyLoad.load({
                    serie: true,
                    files: [
                        "controllers/criarController.js"
                    ]
                });
            }] 
        }
    }

    var depositar = {
        templateUrl : "/views/depositar.html",
        url : "/depositar/:id",
        controller : "depositarController",
        controllerAs : "depositar",
        resolve : {
            deps : ["$ocLazyLoad", function($ocLazyLoad){
                return $ocLazyLoad.load({
                    serie: true,
                    files: [
                        "controllers/depositarController.js"
                    ]
                });
            }] 
        }
    }

    var alterarNome = {
        templateUrl : "/views/alterarNome.html",
        url : "/alterarNome/:id",
        controller : "alterarNomeController",
        controllerAs : "alterarNome",
        resolve : {
            deps : ["$ocLazyLoad", function($ocLazyLoad){
                return $ocLazyLoad.load({
                    serie: true,
                    files: [
                        "controllers/alterarNomeController.js"
                    ]
                });
            }] 
        }
    }

    var transferir = {
        templateUrl : "/views/transferir.html",
        url : "/transferir/:id",
        controller : "transferirController",
        controllerAs : "transferir",
        resolve : {
            deps : ["$ocLazyLoad", function($ocLazyLoad){
                return $ocLazyLoad.load({
                    serie: true,
                    files: [
                        "controllers/transferirController.js"
                    ]
                });
            }] 
        }
    }

    $stateProvider.state("home", home)
                  .state("home.sacar", sacar)
                  .state("home.criar", criar)
                  .state("home.alterarNome", alterarNome)
                  .state("home.transferir", transferir)
                  .state("home.depositar", depositar);
}])