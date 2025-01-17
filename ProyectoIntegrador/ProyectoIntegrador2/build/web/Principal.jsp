<%-- 
    Document   : Principal
    Created on : 26 may. 2024, 00:49:33
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>JSP Page</title>
    <style>
        .logo-header {
            height: 100px;
            background-size: cover;
            background-position: center;
            position: relative;
            z-index: 2;
        }

        .navbar-brand {
            font-weight: bold;
            font-size: 1.2rem;
            color: white;
        }

        .navbar-brand,
        .navbar-nav .nav-link {
            color: white !important;
            text-shadow: 2px -1px 2px rgba(0, 0, 0, 1); /* Sombra de texto */
        }

        .navbar {
            position: relative;
            background: url(IMG/AlmacenNavBarBG.jpeg);
            background-size: cover;
            background-position: center;
        }

        .navbar::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5); /* Capa de oscurecimiento */
            z-index: 1;
        }

        .navbar .navbar-brand,
        .navbar .navbar-nav .nav-link,
        .navbar .btn,
        .navbar .dropdown-menu {
            position: relative;
            z-index: 2;
        }

        .dropdown-menu {
            position: absolute;
            top: 100%;
            left: auto;
            right: 0;
            margin-top: 0.5rem;
        }

        .dropdown-menu.show {
            display: block; /* Forzamos que se muestre el menú desplegable cuando está activo */
            position: absolute;
            top: 100%; /* Para desplegar hacia abajo */
            right: 0; /* Alinea el menú desplegable a la derecha */
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <img class="logo-header" src="IMG/LogoAlmacen.png" alt=""/>
        <a class="navbar-brand navbar-custom" href="#">Almacén</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Materiales</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Proveedores&accion=Listar" target="myFrame">Proveedores</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=RegistrarPedido&accion=default" target="myFrame">Generar Pedido</a>
                </li>
            </ul>
            <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        <img src="IMG/usericon.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">usuario@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">                     
                        <button name="accion" value="Salir" class="dropdown-item">
                            <img src="IMG/cerrarSesion.png" alt="Cerrar Sesión" width="20"/>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </nav>
    <div class="m-4" style="height: 550px;">
        <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
    </div>
    <script src="assets/js/scriptlogin.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDzwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

