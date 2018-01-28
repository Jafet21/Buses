/* global data */

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


function guardarNombre(nombre){
   var query = $("#query").val(nombre);
    alert(query);
    sessionStorage.setItem("query",query);
    window.location = "../html/VerRutas.html";;
    
}


function llenarBarraBuscar(){
    var query =sessionStorage.getItem("query");
    if (query !== null){
        $("#query").val(query);     
    }
}








function obtenerEmpresas() {
    $.ajax({
        url: '../obtenerEmpresas',
        error: function () { //si existe un error en la respuesta del ajax
            swal("Alerta", "Se genero un error, contacte al administrador", "error");
        },
        success: function (data) {
            cargarTablaEmpresas(data);
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
        row += "<td align='right'><button onclick='eliminarRuta(" + ruta.id + ")' type='button'>Eliminar</button><button onclick='' type='button'>Modificar</button></td>";
        row += "</tr>";
        tabla.append(row);
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





function cargarTablaEmpresas(data) {
    for (var i = 0; i < data.length; i++) {
        empresa = data[i];
        $("#tablaEmpresas").append("<tr>" +"<td>" +   empresa.nombre + "</td>"+
                "<td>" +  empresa.correo+"</td>" + "<td>" +  empresa.telefono+"</td>"+
                "<td align='right'><button onclick='test()' type='button' onclick='test()' class='btn btn-default btn-sm' >"+" <span class='glyphicon glyphicon-chevron-down'></span>"+"</button></td>"+
                "</tr> <tr style='display: none'> +<td>" +   empresa.nombre + "</td></tr> ");     
    }
}





