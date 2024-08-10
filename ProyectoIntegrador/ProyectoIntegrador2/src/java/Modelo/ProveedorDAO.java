

package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Proveedor buscar(String dni) {
    Proveedor c = new Proveedor();
    String sql = "SELECT * FROM proveedor WHERE Ruc ="+dni;
    try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEs(rs.getString(5));
            }
        } catch (Exception e) {
        }

        return c;
    }
    
    //OPERACIONES CRUD
    
    public List listar() {
        String sql = "select * from proveedor";
        List<Proveedor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt(1));
                pr.setDni(rs.getString(2));
                pr.setNom(rs.getString(3));
                pr.setDir(rs.getString(4));
                pr.setEs(rs.getString(5));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Proveedor pr) {
        String sql = "insert into proveedor(Ruc, Nombres, Direccion, Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,pr.getDni());
            ps.setString(2, pr.getNom());
            ps.setString(3, pr.getDir());
            ps.setString(4, pr.getEs());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Proveedor listarId(int id) {
        Proveedor pro = new Proveedor();
        String sql = "select * from proveedor where IdProveedor=" + id;
         try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setDni(rs.getString(2));
                pro.setNom(rs.getString(3));
                pro.setDir(rs.getString(4));
                pro.setEs(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pro;
    }
    
    public int actualizar(Proveedor pr) {
        String sql = "update proveedor set Ruc=?, Nombres=?, Direccion=?, Estado=? where IdProveedor=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDni());
            ps.setString(2, pr.getNom());
            ps.setString(3, pr.getDir());
            ps.setString(4, pr.getEs());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
            rs.close();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id) {
        String sql = "delete from proveedor where IdProveedor=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    }
    

