/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(

        );

//-------- Logeo-----------------
function logearEmpresa() {
    if (validacionDatosUsuarioLogeo()) {
        $.ajax({
            url: '../EmpresaLogeo',
            data: {
                correoUsuario: $("#correoEmpresaLogeo").val(),
                contrasenaUsuario: $("#contrasenaEmpresaLogeo").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Credenciales no validos", "error");
            },
            success: function (data) {
                swal("Correcto", "Bienvenido a nuestro sistema", "success");
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}

function registrado(data) {

}

function logearUsuario() {
    if (validacionDatosUsuarioLogeo()) {
        $.ajax({
            url: '../usuarioLogeo',
            data: {
                correoUsuarioLogeo: $("#correoUsuarioLogeo").val(),
                contrasenaUsuarioLogeo: $("#contrasenaUsuarioLogeo").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                alert("Bienvenido");
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}



function validacionDatosUsuarioLogeo() {
    var validacion = true;

    if ($("#correoUsuarioLogeo").val() === "") {
        validacion = false;
    }

    if ($("#contrasenaUsuarioLogeo").val() === "") {
        validacion = false;
    }

    return validacion;
}



function validacionDatosEmpresaLogeo() {
    var validacion = true;

    if ($("#correoEmpresaLogeo").val() === "") {
        validacion = false;
    }

    if ($("#contrasenaEmpresaLogeo").val() === "") {
        validacion = false;
    }

    return validacion;
}

// Get the modal
var modal = document.getElementById('id01');

var modal2 = document.getElementById('id02');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
    if (event.target === modal2) {
        modal2.style.display = "none";
    }
};



