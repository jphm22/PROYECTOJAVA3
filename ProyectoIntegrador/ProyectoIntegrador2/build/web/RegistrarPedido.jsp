
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            .label-bold {
                font-weight: bold;
                margin-right: 10px;
                margin-top:7px;
            }
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        
        <div class="d-flex">
            <div class="col-lg-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=RegistrarPedido" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Proveedor</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                               <input type="text" name="codigoproveedor" value="${c.getDni()}" class="form-control" placeholder="Código"> 
                               <button type="submit" name="accion" value="BuscarProveedor" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-6">
                                <input type="txt" name="nombresproveedores" value="${c.getNom()}" placeholder="Datos del Proveedor" class="form-control" readonly>  
                            </div>           
                        </div>
                        <div class="form-group">
                            <!--DATOS DEL PRODUCTO-->
                            <label>Datos Del Material</label>
                        </div>
                        <div class="form-group d-flex">
                          <div class="col-sm-6 d-flex">
                              <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Código" >
                              <button type="submit" name="accion" value="BuscarMaterial" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-6">
                                <input type="txt" name="nombresproducto" value="${producto.getNom()}" class="form-control" placeholder="Datos del Material" readonly>  
                            </div>  
                        </div>
                        <div class="form-group d-flex">
                           <div class="col-sm-6 d-flex">
                               <input type="text" name="precio" value="${producto.getPre()}" class="form-control" placeholder="S/0.00" readonly>                             
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cant" value="1" placeholder="" class="form-control">  
                            </div>
                            <div class="col-sm-3">
                                <input type="txt" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control" readonly>  
                            </div> 
                        </div>
                            
                            <!<!-- AGREGAR MATERIAL AL REGISTRO -->
                            
                        <div class="form-group">
                            <div class="col-sm">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar Pedido</button>
                            </div>
                        </div>
                    </div>
                  </form>
                </div>               
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label class="label-bold">N.Serie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control" readonly>
                      </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Aciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                             <a href="Controlador?menu=RegistrarPedido&accion=GenerarPedido" onclick="print()" class="btn btn-success">Generar Pedido</a> 
                             <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                           
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="S/. ${totalpagar}0" class="form-control" readonly>
                        </div>
                    </div>
                </div>         
            </div>
        </div>
                        
            <script src="assets/js/scriptlogin.js"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
