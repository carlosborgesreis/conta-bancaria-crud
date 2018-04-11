app.controller("criarController", ["$scope", "$state", "$stateParams","contaService", function($scope, $state, $stateParams, contaService){
    
    var criar = this;

    this.criar = function(form){
        if (form.$valid){
            contaService.criar(criar.criarModel).then(function(response){
                $state.go("home", {}, { reload: true });
            }).catch(function(error){
                $window.alert(error.data.message);
            })
        }
    }

    this.cancelar = function(){
        $state.go("home", {}, { reload: true });
    }

    this.criarModel = {
        cliente : {}
    };
}]);