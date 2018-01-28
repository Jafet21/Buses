var app= angular.module('myApp',[]);
app.controller('namesCtrl',function ($scope, $http){
    $http({
        url: '../obtenerRutas'
          }).then(function mySuccess(response){
              $scope.names= response.data;
                },function myError(response){
                    
                });
    
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
