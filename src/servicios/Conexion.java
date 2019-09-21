package servicios;
import java.sql.*;
public class Conexion {
   private static Connection cnx = null;
   public static Connection obtener() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
             String url = "jdbc:mysql://localhost:3306/simulador";
             String user = "root";
             String pass = "";
             System.out.println("Conectando…");
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user,pass);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
}
