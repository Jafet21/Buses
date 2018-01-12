
function registrarUsuario() {
    if (validacionDatosUsuario()) {
        $.ajax({
            url: '../Registro_Usuario',
            data: {
                accion: "registrarUsuario",
                nombreUsuario: $("#nombreUsuario").val(),
                apellidos: $("#apellidos").val(),
                email: $("#email").val(),
                identificacion: $("#identificacion").val(),
                contrasena: $("#contrasena").val(),
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                swal(data, true);
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}

function registrarEmpresa() {
    if (validacionDatosEmpresa()) {
        $.ajax({
            url: '../Registro_Empresa',
            data: {
                accion: "registrarEmpresa",
                nombreEmpresa: $("#NombreEmpresa").val(),
                telefonoEmpresa: $("#telefonoEmpresa").val(),
                correoEmpresa: $("#correoEmpresa").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                swal("Alerta", "Se genero un error, contacte al administrador", "error");
            },
            success: function (data) {
                swal(data, true);
            },
            type: 'POST'
        });
    } else
        swal("Error", "Verifique que los campos se encuentre con la informacion solicitada", "error");
}

function validacionDatosUsuario() {
    var validacion = true;

    if ($("#identificacion").val() === "") {
       
        validacion = false;
    }
    if ($("#nombreUsuario").val() === "") {
        validacion = false;
    }

    if ($("#pApellido").val() === "") {
        validacion = false;
    }
    if ($("#sApellido").val() === "") {
        validacion = false;
    }
    if ($("#edad").val() === "") {
        validacion = false;
    }
    return validacion;
}

function validacionDatosEmpresa() {
    var validacion = true;

    if ($("#NombreEmpresa").val() === "") {
        validacion = false;
    }
    if ($("#telefonoEmpresa").val() === "") {
        validacion = false;
    }

    if ($("#correoEmpresa").val() === "") {
        validacion = false;
    }

    return validacion;
}

