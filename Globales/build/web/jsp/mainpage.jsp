<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Theme Made By www.w3schools.com - No Copyright -->
        <title>Bootstrap Theme Company Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
        <script src="../javascript/Registro.js" type="text/javascript"></script>

        <link href="../css/estiloMainPage.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#myPage"></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#about">Con�zcanos</a></li>
                        <li><a href="#registrese">Registrese</a></li>
                        <li><a href="#servicios">Servicios</a></li>
                        <li><a href="#ciudades">Ciudades</a></li>  
                        <li><a href="#contact">Cont�ctenos</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="jumbotron text-center">
            <i style="font-size:100px" class="fa">&#xf207;</i>
            <h1>Company</h1> 
            <p>Busque la Ruta que desea conocer</p> 
            <form>
                <div class="input-group">
                    <input type="email" class="form-control"  placeholder="Buscar Ruta" required>
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-info">Buscar</button>
                    </div>
                </div>
            </form>
        </div>

        <!-- Container (About Section) -->
        <div id="about" class="container-fluid">
            <div class="row">
                <div class="col-sm-8">
                    <h2>Con�zcanos</h2><br>
                    <h4>Company es un servicio que ofrece las rutas de autobuses en el Gran �rea Metropolitana. Puedes conocer las rutas, paradas, tarifas, comentarios y quejas de nuestros usuarios adem�s de poder acceder a la informaci�n de las compa�ias de Autobuses.  </h4><br>
                    <p>Al usar nuestra plataforma podras acceder a rutas, tarifas, paradas y dem�s de tu proximo estino. Conocer cual es la opini�n de los diferentes usuarios sobre el servicio de buses de una ruta en especial, ver cual recibe mejor puntaci�n, escoger cual es la m�s conviente, cercana y segura de tu destino. Una vez finalizado tu viaje podras comentarnos las experiencias para compartirlas con otros usuarios y mejorar el servicio de transporte p�blico. </p>

                </div>
                <div class="col-sm-4">
                    <span class="glyphicon glyphicon-road logo"></span>
                </div>
            </div>
        </div>

        <div class="container-fluid bg-grey">
            <div class="row">
                <div class="col-sm-4">
                    <i  class="fa logo">&#xf2b5;</i>
                </div>
                <div class="col-sm-8">
                    <h2>Nuestros Valores</h2><br>
                    <h4><strong>MISI�N:</strong> Nuestra Misi�n es facilitar las rutas,tarifas, paradas de autobuses de la meseta central, para todas aquellas personas que utilizan a diario el transporte p�blico como el bus. Facilitando a todos nuestros usuarios poder compartir sus experiencias y poder observar los comentarios de los demas usuarios y hacer m�s placentero su viaje. </h4><br>
                    <h4><strong>VISION:</strong> Nuestra Visi�n es dirigirnos a ser una empresa que pueda facilitar la informaci�n de las empresas autobuseras para todo el p�blico en general, dando una experiencia mas placentera al usuario. 
                        </h4>
                </div>
            </div>
        </div>


        <div id="registrese" class="container-fluid">
            <div class="row">
                <div >
                    <h2>Registrese </h2><br>
                    <h4>Ingrese sus datos personales, as� como la de su empresa autobusera.</h4><br>
                </div>

                <div  class="col-sm-9 col-md-6">
                    <h4 class="text-center">Usuario</h4>
                    <h4 class="text-center">  <a  data-toggle="collapse" href="#collapse1"><i  class="fa logo-small">&#xf078;</i></a></h4>
                    <div id="collapse1" class="form-group collapse">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <div class="form-group">
                                    <div >
                                        <label  for="id">Identificaci�n:</label>
                                    </div>
                                    <div >
                                        <input type="number" class="form-control" id="identificacion" placeholder="0-0000-0000" name="id">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div >
                                        <label  for="nombre">Nombre:</label>
                                    </div>
                                    <div >
                                        <input type="nombre" class="form-control" id="nombreUsuario" placeholder="Nombre" name="nombre">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div  >
                                        <label  for="apellidos">Apellidos:</label>
                                    </div>
                                    <div  >
                                        <input type="text" class="form-control" id="apellidos" placeholder="Primer Apellido" name="pApellido">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div  >
                                        <label  for="contrasena">Contrase�a:</label>
                                    </div>
                                    <div  >
                                        <input type="text" class="form-control" id="contrasena" placeholder="Contrasena" name="contrasena">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div  >
                                        <label  for="email">Correo:</label>
                                    </div>
                                    <div  >
                                        <input type="email" class="form-control" id="email" placeholder="Correo Electronico" name="email">
                                    </div>
                                </div>
                            </li>
                            <button onclick='registrarUsuario();'>Registrarme</button>
                        </ul>

                    </div>
                </div>

                <div class="col-sm-9 col-md-6">
                    <h4 class="text-center">Empresa</h4>
                    <h4 class="text-center">  <a  data-toggle="collapse" href="#collapse2"><i  class="fa logo-small">&#xf078;</i></a></h4>
                    <div id="collapse2" class="panel-collapse collapse">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <div class="form-group">
                                    <div>
                                        <label  for="nombreEmpresa">Nombre de la Empresa:</label>
                                    </div>
                                    <div>
                                        <input type="nombre" class="form-control" id="NombreEmpresa" placeholder="Nombre de la Empresa" name="nombreE">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div >
                                        <label  for="telefonoEmpresa">Tel�fono:</label>
                                    </div>
                                    <div >
                                        <input type="nombre" class="form-control" id="telefonoEmpresa" placeholder="Tel�fono empresarial" name="telefonoE">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div>
                                        <label  for="correoEmpresa">Correo electr�nico:</label>
                                    </div>
                                    <div >
                                        <input type="nombre" class="form-control" id="correoEmpresa" placeholder="Correo empresarial" name="correoE">
                                    </div>
                                </div>
                            </li>
                            <button onclick='registrarEmpresa()();'>Registrar Empresa</button>
                        </ul>
                    </div>

                </div>
            </div>
        </div>


        <!-- Container (Services Section) -->
        <div id="servicios" class="container-fluid text-center">
            <h2>Servicios</h2>
            <h4>Te ofrecemos...</h4>
            <br>
            <div class="row slideanim">
                <div class="col-sm-4">
                    <span class="fa fa-money logo-small"></span>
                    <h4>Tarifas</h4>
                    <p>Costo de los pasajes.</p>
                </div>
                <div class="col-sm-4">
                    <i  class="fa logo-small">&#xf126;</i>
                    <h4>Rutas</h4>
                    <p>Las paradas de las rutas a su destino.</p>
                </div>
                <div class="col-sm-4">
                    <i  class="fa logo-small">&#xf2c3;</i>
                    <h4>Informaci�n</h4>
                    <p>Informaci�n de la empresa autobusera que frecuenta.</p>
                </div>
            </div>
            <br><br>
            <div class="row slideanim">
                <div class="col-sm-4">

                </div>
                <div class="col-sm-4">
                    <<i  class="fa logo-small">&#xf0e6;</i>
                    <h4>Comunidad</h4>
                    <p>Podras leer y aportar a la comunidad de comentarios.</p>
                </div>
                <div class="col-sm-4">

                </div>
            </div>
        </div>

        <!-- Container (Portfolio Section) -->
        <div id="ciudades" class="container-fluid text-center bg-grey">
            <h2>Ciudades</h2><br>
            <h4>Valle Central</h4>
            <div class="row text-center slideanim">
                <div class="col-xs-6 col-sm-3">
                    <div class="thumbnail">
                        <img src="../imagenes/san jose.jpg" alt="San Jos�" width="400" height="300">
                        <p><strong>San Jos�</strong></p>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3">
                    <div class="thumbnail">
                        <img src="../imagenes/alajuela.jpg" alt="Alajuela" width="400" height="300">
                        <p><strong>Alajuela</strong></p>

                    </div>
                </div>
                <div class="col-xs-6 col-sm-3">
                    <div class="thumbnail">
                        <img src="../imagenes/heredia.JPG" alt="Heredia" width="400" height="300">
                        <p><strong>Heredia</strong></p>

                    </div>
                </div>
                <div class="col-xs-6 col-sm-3">
                    <div class="thumbnail">
                        <img src="../imagenes/cartago.jpg" alt="Cartago" width="400" height="300">
                        <p><strong>Cartago</strong></p>

                    </div>
                </div>
            </div><br>

            <h2>Sus Comentarios</h2>
            <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <h4>"La manera mas r�pida de viaja de Heredia a San Jos� es por la ruta de Tibas!"<br><span>Felipe Jim�nez</span></h4>
                    </div>
                    <div class="item">
                        <h4>"El servicio de la TUASA es aceptable...!"<br><span>John Delgado</span></h4>
                    </div>
                    <div class="item">
                        <h4>"Los buses de LUMACA son muy malos hay muchos en mal estado deberian de cambiarlos !"<br><span>Carlos Ramirez</span></h4>
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>



        <!-- Container (Contact Section) -->
        <div id="contact" class="container-fluid bg-grey">
            <h2 class="text-center">Cont�ctenos</h2>
            <div class="row">
                <div class="col-sm-5">
                    <p>Recibimos sus comentarios y sugerecias hacerca de nuestro servicio.</p>
                    <p><i style="font-size:22px" class="fa">&#xf21d;</i></span> Heredia,Costa Rica</p>
                    <p><i style="font-size:22px" class="fa">&#xf098;</i> +506 2222-2222</p>
                    <p><i style="font-size:22px" class="fa">&#xf003;</i>  correoCompany@correo.com</p>
                </div>
                <div class="col-sm-7 slideanim">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="name" name="name" placeholder="Nombre" type="text" required>
                        </div>
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="email" name="email" placeholder="Correo" type="email" required>
                        </div>
                    </div>
                    <textarea class="form-control" id="comments" name="comments" placeholder="Comentario" rows="5"></textarea><br>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <button class="btn btn-default pull-right" type="submit">Enviar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <footer class="container-fluid text-center">
            <a href="#myPage" title="To Top">
                <span class="glyphicon glyphicon-chevron-up"></span>
            </a>

        </footer>

        <script>
            $(document).ready(function () {
                // Add smooth scrolling to all links in navbar + footer link
                $(".navbar a, footer a[href='#myPage']").on('click', function (event) {
                    // Make sure this.hash has a value before overriding default behavior
                    if (this.hash !== "") {
                        // Prevent default anchor click behavior
                        event.preventDefault();

                        // Store hash
                        var hash = this.hash;

                        // Using jQuery's animate() method to add smooth page scroll
                        // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
                        $('html, body').animate({
                            scrollTop: $(hash).offset().top
                        }, 900, function () {

                            // Add hash (#) to URL when done scrolling (default click behavior)
                            window.location.hash = hash;
                        });
                    } // End if
                });

                $(window).scroll(function () {
                    $(".slideanim").each(function () {
                        var pos = $(this).offset().top;

                        var winTop = $(window).scrollTop();
                        if (pos < winTop + 600) {
                            $(this).addClass("slide");
                        }
                    });
                });
            })
        </script>

    </body>
</html>
