


//-------- Logeo-----------------
function loguearEmpresa() {
    if (validacionDatosEmpresaLogeo()) {
        $.ajax({
            url: '../EmpresaLogeo',
            data: {
                correoEmpresaLogeo: $("#correoEmpresaLogeo").val(),
                contrasenaEmpresaLogeo: $("#contrasenaEmpresaLogeo").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Credenciales no validos", "error");
                alert("Su usuario y contrasena son Invalidos intentelo mas tarde!");
            },
            success: function (data) {
                alert("Bienvenido a nuestro sistema "+ data.nombre);
                swal("Correcto", "Bienvenido a nuestro sistema", "success");
                window.location = "../html/AdministrarRutas.html";
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
                alert("Su usuario y contraseña son Invalidos intentelo más tarde!");
                
            },
            success: function (data) {
                alert("Bienvenido a nuestro sistema "+ data.nombre);
                swal("Correcto", "Bienvenido a nuestro sistema "+ data.nombre, "success");
               
                window.location = "../html/PaginaPrincipal.html";

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









