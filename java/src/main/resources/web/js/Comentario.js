function registrarComentario() {
    if (validacionDatosComentario()) {
        $.ajax({
            url: '../registrarComentario',
            data: {
                nombreUsuarioC: $("#nombreComentarioC").val(), 
                nombreRuta: $("#rutaComentario").val(),      
                comentario: $("#comentarios").val(),     
                fecha: $("#fechaComentario").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                alert("Correcto", "Ha sido registrado Su Comentario", "success");
                window.location.href = "Comentario.html";
            },
            type: 'POST'
        });
    } else
        alert("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}


function validacionDatosComentario() {
    var validacion = true;
    
    if ($("#nombreComentarioC").val() === "") {
        validacion = false;
    }
    if ($("#rutaComentario").val() === "") {
        validacion = false;
    }
    if ($("#fechaComentario").val() === "") {
        validacion = false;
    }
    if ($("#comentarios").val() === "") {
        validacion = false;
    }
    return validacion;
}


var app= angular.module('comentarioC',[]);
app.controller('TComentario',function ($scope, $http){
    $http({
        url: '../obtenerComentarios'
          }).then(function mySuccess(response){
              $scope.names= response.data;
                },function myError(response){
                    
                });
    
});