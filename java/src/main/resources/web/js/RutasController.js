var app= angular.module('myApp',[]);
app.controller('namesCtrl',function ($scope, $http, $httpParamSerializer){
$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
    $http({
        url: '../obtenerRutas'
          }).then(function mySuccess(response){
              $scope.names= response.data;
                },function myError(response){
                    
                });

    $scope.eliminarRuta = function(){
       $http({
                method: 'post',
               url: '../eliminarRuta/'+$scope.rutaSeleccionada
                 }).then(function mySuccess(response){
                 location.href='AdministrarRutas.html';
                       },function myError(response){

                       });
    }

    $scope.agregarHorario = function(){
           $http({
                           method: 'post',
                          url: '../agregarHorario',
                          data: $httpParamSerializer({rutaId: $scope.rutaSeleccionada, horario: $scope.horario})
                            }).then(function mySuccess(response){
                            location.href='AdministrarRutas.html';
                                  },function myError(response){

                                  });
    }
});


var app= angular.module('myApp2',[]);
app.controller('namesCtrl2',function ($scope, $http){
    $http({
        url: '../obtenerEmpresas'
          }).then(function mySuccess(response){
              $scope.names= response.data;
                },function myError(response){
                    
                });
    
});
