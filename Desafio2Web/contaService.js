app.service("contaService", ["$http", "serviceBase", "$stateParams",  function ($http, serviceBase, $stateParams) {
    this.listar = function () {
        return $http.get(serviceBase.url + "listar").then(function (response) {
            return response.data;
        });
    }

    this.sacar = function(request){
        return $http.put(serviceBase.url + "sacar", request).then(function (response) {
            return response.data;
        });
    }

    this.criar = function(request){
        return $http.post(serviceBase.url + "criar", request).then(function (response) {
            return response.data;
        });
    }

    this.depositar = function(request){
        return $http.put(serviceBase.url + "depositar", request).then(function (response) {
            return response.data;
        });
    }

    this.alterarNome = function(request){
        return $http.put(serviceBase.url + "alterarNome", request).then(function (response) {
            return response.data;
        });
    }

    this.transferir = function(request){
        return $http.put(serviceBase.url + "transferir", request).then(function (response) {
            return response.data;
        });
    }

    this.deletar = function(request){
        return $http.post(serviceBase.url + "deletar", request).then(function(response){
            return response.data;
        })
    }
}]);