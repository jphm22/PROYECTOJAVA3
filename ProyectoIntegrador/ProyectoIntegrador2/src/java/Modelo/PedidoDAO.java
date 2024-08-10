

package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PedidoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) from pedidos";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }
    
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdPedido) from pedidos";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                idventas=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }
        public int guardarVenta(Pedido ve) {
                String sql = "INSERT INTO pedidos(IdProveedor, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) values(?,?,?,?,?,?)";
                try {
                    con = cn.Conexion();
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, ve.getIdproveedor());
                    ps.setInt(2, ve.getIdempleado());
                    ps.setString(3, ve.getNumserie());
                    ps.setString(4, ve.getFecha());
                    ps.setDouble(5, ve.getMonto());
                    ps.setString(6, ve.getEstado());
                    ps.executeUpdate();
                    System.out.println(ve.getIdproveedor()+" "+ ve.getIdempleado()+" "+ve.getNumserie()+" "+ve.getFecha()+" "+ve.getMonto()+" "+ve.getEstado()+" " );
                } catch (Exception e) {
                }
                return r;
            }

            public int guardarDetalleventas(Pedido venta){
                String sql="insert into detalle_pedidos(IdPedido, IdProducto, Cantidad, PrecioVenta) values(?,?,?,?)";
                try {
                   con=cn.Conexion();
                   ps=con.prepareStatement(sql); 
                   ps.setInt(1, venta.getId());
                   ps.setInt(2, venta.getIdproducto());
                   ps.setInt(3, venta.getCantidad());
                   ps.setDouble(4, venta.getPrecio());
                   ps.executeUpdate();
                } catch (Exception e) {
                }
                return r;
            }
}
