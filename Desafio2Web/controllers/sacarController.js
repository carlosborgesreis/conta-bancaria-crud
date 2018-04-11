app.controller("sacarController", ["$scope", "$state", "$stateParams", "contaService", "$window", function($scope, $state, $stateParams, contaService, $window){
    
    var sacar = this;

    this.sacar = function(form){
        if (form.$valid){
            contaService.sacar(sacar.sacarModel).then(function(response){
                $state.go("home", {}, { reload: true });
            }).catch(function(error){
                $window.alert(error.data.message);
            })
        }
    }

    this.cancelar = function(){
        $state.go("home", {}, { reload: true });
    }

    this.sacarModel = {
        id : $stateParams.id
    };
}]);