function obtenerRutasDeEmpresa() {
    $.ajax({
        url: '../obtenerRutas',
        error: function () { //si existe un error en la respuesta del ajax
            swal("Alerta", "Se genero un error, contacte al administrador", "error");
        },
        success: function (data) {
            cargarTabla(data);
        },
        type: 'GET'
    });

}

function cargarTabla(data) {
    var tabla = $("#tablaRutas");
    tabla.empty();
    for (var i = 0; i < data.length; i++) {
        ruta = data[i];
        var row = "<tr>";
        row += "<td>" + ruta.descripcion + "</td>";
        row += "<td>" + ruta.tiempoEstimado + " minutos</td>";
        row += "<td>" + "</td>";
        row += "<td align='right'><button onclick='eliminarRuta(" + ruta.id + ")' type='button'>Eliminar</button><button onclick='' type='button'>Modificar</button></td>"
        row += "</tr>";
        tabla.append(row)
    }
}

function eliminarRuta(id) {
    $.ajax({
        url: '../eliminarRuta',
        data: {
            id: id
        },
        error: function () { //si existe un error en la respuesta del ajax
            swal("Alerta", "Se genero un error, contacte al administrador", "error");
        },
        success: function (data) {
            obtenerRutasDeEmpresa();
        },
        type: 'POST'
    });
}

function cargarEmpresas() {
    $.ajax({
        url: '../obtenerEmpresas',
        data: {
        },
        error: function () { //si existe un error en la respuesta del ajax
            swal("Alerta", "Se genero un error, contacte al administrador", "error");
        },
        success: function (data) {
            cargarTablaEmpresas();
        },
        type: 'POST'
    });
}

function cargarTablaEmpresas() {
    var tabla = $("#tablaEmpresas");
    tabla.empty();
    for (var i = 0; i < data.length; i++) {
        empresa = data[i];
        var row = "<tr>";
        row += "<td>" + empresa.nombre + "</td>";
        row += "<td>" + "</td>";
        row += "<td align='right'><button onclick='eliminarRuta(" + ruta.id + ")' type='button'>Eliminar</button><button onclick='' type='button'>Modificar</button></td>"
        row += "</tr>";
        tabla.append(row)
    }
}