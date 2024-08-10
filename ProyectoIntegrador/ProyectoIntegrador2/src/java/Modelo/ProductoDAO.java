package Modelo;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    /*public Producto buscar(int id){
        Producto p = new Producto();
        String sql="select * from producto where idproducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(4));
            }
        } catch (Exception e) {
        }
        return p;
    }*/
    /*public int actualizarstock(int id, int stock) {
        String sql = "update producto set Stock=? where idproducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            r=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return r;
    }*/
    
    
 //OPERACIONES CRUD
    
    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Producto em = new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));
                em.setPre(rs.getDouble(3));
             // em.setTamano(rs.getString(4));
                em.setStock(rs.getInt(4));
                em.setEstado(rs.getString(5));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Producto em) {
        String sql = "insert into producto(Nombres, Precio, Stock, Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setDouble(2, em.getPre());
        //  ps.setString(3, em.getTamano());
            ps.setInt(3, em.getStock());
            ps.setString(4, em.getEstado());          
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Producto listarId(int id) {
        Producto pr = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1)); //modificacion para el registro de pedidos
                pr.setNom(rs.getString(2));
                pr.setPre(rs.getDouble(3));
              //pr.setTamano(rs.getString(4));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        } 
        return pr;
    }
    
    public int actualizar(Producto em) {
        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setDouble(2, em.getPre());
         // ps.setString(3, em.getTamano());
            ps.setInt(3, em.getStock());
            ps.setString(4, em.getEstado());
            ps.setInt(5, em.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
            rs.close();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        } 
    }
    
}