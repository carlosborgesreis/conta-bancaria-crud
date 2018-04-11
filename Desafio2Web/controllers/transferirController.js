app.controller("transferirController", ["$scope", "$state", "$stateParams", "contaService", "$window", function($scope, $state, $stateParams, contaService, $window){
    
    var transferir = this;

    this.transferir = function(form){
        if (form.$valid){
            contaService.transferir(transferir.transferirModel).then(function(response){
                $state.go("home", {}, { reload: true });
            }).catch(function(error){
                $window.alert(error.data.message);
            })
        }
    }

    this.cancelar = function(){
        $state.go("home", {}, { reload: true });
    }

    this.transferirModel = {
        id1 : $stateParams.id
    };

    contaService.listar().then(function(response){
        transferir.contasFiltered = _.filter(response, function(o) { return o.contaId != $stateParams.id});  
    })
}]);