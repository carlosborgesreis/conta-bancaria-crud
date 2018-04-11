app.controller("alterarNomeController", ["$scope", "$state", "$stateParams", "contaService", "$window", function($scope, $state, $stateParams, contaService, $window){
    
    var alterarNome = this;

    this.alterarNome = function(form){
        if (form.$valid){
            contaService.alterarNome(alterarNome.alterarNomeModel).then(function(response){
                $state.go("home", {}, { reload: true });
            }).catch(function(error){
                $window.alert(error.data.message);
            })
        }
    }

    this.cancelar = function(){
        $state.go("home", {}, { reload: true });
    }

    this.alterarNomeModel = {
        id : $stateParams.id,
        cliente : {}
    };
}]);