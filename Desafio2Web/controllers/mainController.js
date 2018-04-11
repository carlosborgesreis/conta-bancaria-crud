app.controller("mainController", ["$scope", "$http", "contaService", function ($scope, $http, contaService) {
    contaService.listar().then(function (response) {
        $scope.contas = response;
    });
}]);

