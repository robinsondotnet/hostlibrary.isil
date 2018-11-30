<%-- 
    Document   : index
    Created on : 14/11/2018, 07:29:16 PM
    Author     : ALUMNO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Game of Thrones</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="./Resources/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="./Resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./Resources/css/estilos.css">
   
</head>

<body>


    <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav_collapse">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </button>
            <a class="navbar-brand" href="#">Bodega</a>
        </div>

        <div class="collapse navbar-collapse nav_collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">Crusbel López</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle img_nav" data-toggle="dropdown">
                        <img src="Resources/images/1.png" alt="Crusbel Lopez">
                        <i class="fa fa-caret-down" aria-hidden="true"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Perfil</a></li>
                        <li><a href="#">Notificaciones</a></li>
                        <li><a href="#">Configuración</a></li>
                        <li><a href="#">Salir</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                <div class="list-group list_menu">
                    <a href="#" class="list-group-item">Ventas</a>
                    <a href="#" class="list-group-item">Compras</a>
                    <a href="listar_productos.do" class="list-group-item activate">Productos</a>
                    <a href="#" class="list-group-item">Consultas</a>
                    <a href="#" class="list-group-item">Reportes</a>
                    <a href="#" class="list-group-item">Configuración</a>
                    <a href="#" class="list-group-item">Salir</a>
                </div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-9 col-lg-10">

                <div class="container-fluid">
                    <div class="row">
                        <h1 class="">Productos</h1>
                    </div>

                    <div class="row">

                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#lista" aria-controls="lista" role="tab" data-toggle="tab">Lista</a></li>
                            <li role="presentation"><a href="#nuevo" aria-controls="nuevo" role="tab" data-toggle="tab">Nuevo</a></li>
                            <li role="presentation"><a href="#stock" aria-controls="stock" role="tab" data-toggle="tab">En Stock</a></li>
                            <li role="presentation"><a href="#nostock" aria-controls="nostock" role="tab" data-toggle="tab">Fuera de Stock</a></li>
                        </ul>

                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade in active" id="lista">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
                                            <form>
                                                <div class="input-group search_color">
                                                    <input type="text" class="form-control" id="search_lista" placeholder="Search">
                                                    <span class="input-group-btn">
                                                        <button type="button" class="btn"><i class="fa fa-search" aria-hidden="true"></i></button>
                                                    </span>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="row table-responsive">
                                        <table class="table table-hover table-bordered text-center">
                                            <thead>
                                                <tr>
                                                    <th class="text-center"><i class="fa fa-hashtag" aria-hidden="true"></i></th>
                                                    <th class="text-center">Artículo</th>
                                                    <th class="text-center">Categoría</th>
                                                    <th class="text-center">Descripción</th>
                                                    <th class="text-center">Precio</th>
                                                    <th class="text-center">Stock</th>                                                    
                                                    <th class="text-center">Estado</th>
                                                    <th class="text-center">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="producto" items="${sessionScope.lista}">
                                                    <tr>
                                                        <td>${producto.id}</td>
                                                        <td>${producto.nombre}</td>
                                                        <td>${producto.categoria}</td>
                                                        <td>${producto.descripcion}</td>
                                                        <td>${producto.precio}</td>
                                                        <td>${producto.stock}</td>
                                                        <c:if test="${producto.estado == 1 }">
                                                            <td class="success estado${producto.id}">Alta</td>
                                                        </c:if>
                                                        <c:if test="${producto.estado == 0 }">
                                                            <td class="danger estado${producto.id}">Baja</td>
                                                        </c:if>
                                                        <td class="group_acciones">
                                                            <a href="javascript:void(0);" onclick="cambiarEstado(${producto.id},1);"><i class="fa fa-arrow-up" aria-hidden="true"></i></a>
                                                            <a href="javascript:void(0);" onclick="cambiarEstado(${producto.id},0);"><i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                                                            <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                                            <a href="#"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div role="tabpanel" class="tab-pane fade" id="nuevo">Nuevo producto</div>
                            <div role="tabpanel" class="tab-pane fade" id="stock">Stock</div>
                            <div role="tabpanel" class="tab-pane fade" id="nostock">Sin stock</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <script src="./Resources/js/jquery.js"></script>
    <script src="./Resources/js/bootstrap.min.js"></script>
    <script>
        function cambiarEstado( id, estado )
        {
        $.ajax({
            url:"controlador_update_estado.do",
            data:{
                id:id,
                estado:estado
            },
            success:function (result){
              console.log(result);
              if(result == 1)
              {
                $('.estado'+id).removeClass('danger');
                $('.estado'+id).addClass('success');
                $('.estado'+id).text('Alta');
              }
              else
              {
                $('.estado'+id).removeClass('success');
                $('.estado'+id).addClass('danger');
                $('.estado'+id).text('Baja');
              }
            }
        });  
        }
        
    </script>
</body>

</html>