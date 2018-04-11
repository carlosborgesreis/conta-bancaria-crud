app.controller("homeController", ["$scope", "$state", "contaService", function ($scope, $state, contaService) {

    var home = this;
    
    var carregarListagem = function(){
        contaService.listar().then(function (response) {
            home.contas = response;
        });
    }

    this.sacar = function (conta) {
        $state.go("home.sacar", {
            id: conta.contaId
        });
    }

    this.criar = function (conta) {
        $state.go("home.criar");
    }

    this.depositar = function (conta) {
        $state.go("home.depositar", {
            id: conta.contaId
        });
    }

    this.alterarNome = function (conta) {
        $state.go("home.alterarNome", {
            id: conta.contaId
        });
    }

    this.transferir = function (conta) {
        $state.go("home.transferir", {
            id: conta.contaId
        });
    }

    this.deletar = function (conta) {
        var confirmated = confirm("Deseja cancelar a conta?");
        if (confirmated) {
            contaService.deletar({
                id : conta.contaId
            }).then(function(){
                carregarListagem();
            });
        } 
    }

    carregarListagem();
}]);