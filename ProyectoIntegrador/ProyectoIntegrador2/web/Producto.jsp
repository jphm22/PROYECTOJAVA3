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
        
          <h1>Registrar Materiales</h1>
        <div class="d-flex">
          <div class="card" col-sm-6>
            <div class="card-body">
                <form action="Controlador?menu=Producto" method="POST">
                    
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" value="${producto.getNom()}" name="txtNom" class="form-control">
                    </div>
                    
                    <div class="form-group">
                        <label>Precio</label>
                        <input type="text" value="${producto.getPre()}" name="txtPre" class="form-control">
                    </div>
                    
                    <div class="form-group">
                        <label>Stock</label>
                        <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                    </div>
                    
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    
                </form>
            </div>
        </div>
            <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        
                        <th>NOMBRE</th>
                        <th>PRECIO</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pro" items="${productos}">
                    <tr>
                        <td style="<c:if test='${pro.getStock() <= 10}'>border: 2px solid red;</c:if>" >${pro.getNom()}</td>
                        <td style="<c:if test='${pro.getStock() <= 10}'>border: 2px solid red;</c:if>" >${pro.getPre()}</td>
                        <td style="<c:if test='${pro.getStock() <= 10}'>border: 2px solid red;</c:if>" >${pro.getStock()}</td>
                        <td>${pro.getEstado()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pro.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pro.getId()}">Eliminar</a>
                        </td>
                    </tr>                        
                    </c:forEach>
                </tbody>
            </table>

        </div>  
        </div>
        
            <script src="assets/js/scriptlogin.js"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
