

package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TestConexion {
    public static void main(String[] args) {
        Connection con = null;
        String bd = "integradorbd";
        String url = "jdbc:mysql://localhost:3306/" + bd; // Asegúrate de que el puerto es correcto
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}