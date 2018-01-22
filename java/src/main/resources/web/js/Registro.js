
function registrarUsuario() {
    if (validacionDatosUsuario()) {
        $.ajax({
            url: '../registrarUsuario',
            data: {
                nombreUsuario: $("#nombreUsuario").val(),
                apellidos: $("#apellidos").val(),
                correoUsuario: $("#correoUsuario").val(),
                contrasenaUsuario: $("#contrasenaUsuario").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                swal("Correcto", "Ha sido registrado en nuestro sistema", "success");
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}

function registrarRuta() {
    if (validacionDatosUsuario()) {
        $.ajax({
            url: '../registrarRuta',
            data: {
                descripcion: $("#descripcion").val(),
                tiempoEstimado: $("#tiempoEstimado").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                window.location.href = "AdministrarRutas.html";
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}

function registrarEmpresa() {
    if (validacionDatosEmpresa()) {
        $.ajax({
            url: '../registrarEmpresa',
            data: {
                nombreEmpresa: $("#nombreEmpresa").val(),
                telefonoEmpresa: $("#telefonoEmpresa").val(),
                correoEmpresa: $("#correoEmpresa").val(),
                contrasenaEmpresa: $("#contrasenaEmpresa").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                swal("Registrado", "Se ha registrado satiscatoriamente", "success");
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}

function validacionDatosUsuario() {
    var validacion = true;

    if ($("#nombreUsuario").val() === "") {
        validacion = false;
    }

    if ($("#apellidos").val() === "") {
        validacion = false;
    }
    if ($("#correoUsuario").val() === "") {
        validacion = false;
    }

    if ($("#contrasenaUsuario").val() === "") {
        validacion = false;
    }

    if ($("#confirmacionContrasena").val() !== $("#contrasenaUsuario").val()) {
        swal("Error", "La contraseña no coincide", "error");
        validacion = false;
    }
    return validacion;
}

function validacionDatosEmpresa() {
    var validacion = true;

    if ($("#nombreEmpresa").val() === "") {
        validacion = false;
    }
    if ($("#telefonoEmpresa").val() === "") {
        validacion = false;
    }

    if ($("#correoEmpresa").val() === "") {
        validacion = false;
    }

    if ($("#contrasenaEmpresa").val() === "") {
        validacion = false;
    }

    return validacion;
}



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
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                swal("Correcto", "Bienvenido a nuestro sistema", "success");
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}

function logearUsuario() {
    if (validacionDatosUsuarioLogeo()) {
        $.ajax({
            url: '../usuarioLogeo',
            data: {
                correoUsuario: $("#correoUsuarioLogeo").val(),
                contrasenaUsuario: $("#contrasenaUsuarioLogeo").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                swal("Correcto", "Bienvenido a nuestro sistema", "success");
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
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
    if (event.target === modal2) {
        modal2.style.display = "none";
    }
};