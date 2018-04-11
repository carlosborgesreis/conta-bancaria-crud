app.controller("depositarController", ["$scope", "$state", "$stateParams", "contaService", "$window", function($scope, $state, $stateParams, contaService, $window){
    
    var depositar = this;

    this.depositar = function(form){
        if (form.$valid){
            contaService.depositar(depositar.depositarModel).then(function(response){
                $state.go("home", {}, { reload: true });
            }).catch(function(error){
                $window.alert(error.data.message);
            })
        }
    }

    this.cancelar = function(){
        $state.go("home", {}, { reload: true });
    }

    this.depositarModel = {
        id : $stateParams.id
    };
}]);