

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="ml-4 mt-4 mr-4">
        <div class="row">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador?menu=Proveedores" method="POST">
                        <div class="form-group">
                            <label>RUC</label>
                            <input type="text" value="${proveedor.getDni()}" name="txtRuc" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${proveedor.getNom()}" name="txtNom" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${proveedor.getDir()}" name="txtDir" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${proveedor.getEs()}" name="txtEs" class="form-control">
                        </div>                        
                        <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>                         
            </div>
        </div>                     
        <div class="col-sm-8">
            <div class="card">
                <div class="card-body">
                    <table class="table" style="width: 100%" id="example">
                        <thead>
                            <tr class="text-center">
                                                             
                                <th>RUC</th>
                                <th>NOMBRE</th>
                                <th>DIRECCION</th>
                                <th>ESTADO</th>                                   
                                <th>ACCION</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <c:forEach var="pr" items="${proveedores}">
                                <tr>                                   
                                    <td>${pr.getDni()}</td>
                                    <td>${pr.getNom()}</td>
                                    <td>${pr.getDir()}</td>
                                    <td>${pr.getEs()}</td>
                                                     
                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=Proveedores&accion=Editar&id=${pr.getId()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=Proveedores&accion=Delete&id=${pr.getId()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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
