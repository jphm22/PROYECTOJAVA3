package Controlador;

import Config.GenerarSerie;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Pedido;
import Modelo.PedidoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Proveedor c = new Proveedor();
    ProveedorDAO cdao = new ProveedorDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();

    int ide; //Editar
    int idc;
    int idp;

    Pedido v = new Pedido();
    List<Pedido> lista = new ArrayList<>();
    
    //tabla registrar pedido
    int item;
    int cod;//codigo de profucto
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;

    String numeroserie;
    PedidoDAO vdao = new PedidoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {//EMPLEADO
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    // Redirecciona después de agregar
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return; // Añadir return para evitar redirección doble

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;

                case "Actualizar":

                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");

                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;

                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);

            //VENTANA DE PROVEEDORES
        }
        if (menu.equals("Proveedores")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("proveedores", lista);//debajodelabel
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtRuc");
                    String nom = request.getParameter("txtNom");
                    String dir = request.getParameter("txtDir");
                    String es = request.getParameter("txtEs");
                    c.setDni(dni);
                    c.setNom(nom);
                    c.setDir(dir);
                    c.setEs(es);
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Proveedor cl = cdao.listarId(idc);
                    request.setAttribute("proveedor", cl);//label
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtRuc");
                    String nom1 = request.getParameter("txtNom");
                    String dir1 = request.getParameter("txtDir");
                    String es1 = request.getParameter("txtEs");
                    c.setDni(dni1);
                    c.setNom(nom1);
                    c.setDir(dir1);
                    c.setEs(es1);
                    c.setId(idc);
                    cdao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Proveedores.jsp").forward(request, response);

            //VENTANA DE MATERIALES    
        }
        if (menu.equals("Producto")) {//PRODUCTO
            switch (accion) {
                case "Listar":
                    List productos = pdao.listar();
                    request.setAttribute("productos", productos);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNom");
                    double pre = Double.parseDouble(request.getParameter("txtPre"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado = request.getParameter("txtEstado");
                    p.setNom(nom);
                    p.setPre(pre);
                    p.setStock(stock);
                    p.setEstado(estado);
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto pro = pdao.listarId(idp);
                    request.setAttribute("producto", pro);//label
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1 = request.getParameter("txtNom");
                    double pre1 = Double.parseDouble(request.getParameter("txtPre"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String estado1 = request.getParameter("txtEstado");
                    p.setNom(nom1);
                    p.setPre(pre1);
                    p.setStock(stock1);
                    p.setEstado(estado1);
                    p.setId(idp);
                    pdao.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        //REGISTRO DE PEDIDO

        if (menu.equals("RegistrarPedido")) {
            
            switch (accion) {
                case "BuscarProveedor"://BOTON
                    String dni = request.getParameter("codigoproveedor"); //a
                    c.setDni(dni);
                    c = cdao.buscar(dni);
                    
                    request.setAttribute("c", c);//"c"para los ${}
                    request.setAttribute("nserie", numeroserie);
                    break;

                case "BuscarMaterial":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));//
                    p = pdao.listarId(id);

                    request.setAttribute("c", c);//mantener datos
                    request.setAttribute("producto", p);//"c"para los ${}
                    request.setAttribute("lista", lista);//para agregar a la lista de RP sin que se borre
                    request.setAttribute("totalpagar", totalPagar);// para que no se borre al agregar producto 
                    request.setAttribute("nserie", numeroserie);

                    break;

                case "Agregar":
                    
                    request.setAttribute("c", c);
                    ;//mantener datos
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    descripcion = request.getParameter("nombresproducto");//caja de texto del getNom del producto
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;

                    ;

                    v = new Pedido();
                    v.setItem(item);
                    v.setIdproducto(cod); //cambio
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);

                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                        request.setAttribute("nserie", numeroserie);
                    }

                    /*String precioStr = request.getParameter("precio");
               String cantStr = request.getParameter("cant");

               if (precioStr != null && !precioStr.isEmpty() && cantStr != null && !cantStr.isEmpty()) {
                   precio = Double.parseDouble(precioStr);
                   cant = Integer.parseInt(cantStr);
                   subtotal = precio * cant;
                   v = new Pedido();                           
                   v.setItem(item); 
                   v.setIdproducto(cod);
                   v.setDescripcionP(descripcion);
                   v.setPrecio(precio);
                   v.setCantidad(cant);
                   v.setSubtotal(subtotal);
                   lista.add(v);

                   for (int i = 0; i < lista.size(); i++) {
                       totalPagar = totalPagar + lista.get(i).getSubtotal();
                   }
                   request.setAttribute("totalpagar", totalPagar);
                   request.setAttribute("lista", lista);  
                   request.setAttribute("nserie", numeroserie);
               } else {
                   // Manejo si el precio o la cantidad están vacíos
                   System.out.println("Precio o cantidad vacíos.");
               }*/
                    break;

                case "GenerarPedido":

                    //ACTUALIZAR STOCK
                    //GUARDAR VENTA
                    v.setIdproveedor(c.getId());
                    v.setIdempleado(2);
                    v.setNumserie(numeroserie);
                    v.setFecha("2024-05-17");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //GUARDAR DETALLE VENTAS
                    int idv = Integer.parseInt(vdao.IdVentas());
                    //if (idv != 0) {
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Pedido();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    lista = new ArrayList<>();
                    /*} else {
                        // Manejo si el ID de ventas devuelto es 0
                        System.out.println("El ID de ventas es 0.");
                    } */

                    break;

                default:

                    v = new Pedido();
                    
                    item = 0;
                    totalPagar = 0.0;

                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);

                    }
            }
            request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
