import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
   Connection conectar = null;

  public Connection conexion(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      System.out.println("Registrado");
      System.out.println("");

      conectar = DriverManager.getConnection("jdbc:mysql://localhost/pong?"
          + "useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root" );
      System.out.println(" Conectado \n");

    }catch (Exception ex){
      System.out.print(ex.getMessage());
      System.out.println("\n Error, no se pudo conectar");
    }
    return conectar;
  }

  public void cerrarConexion(){
    try{
      conectar.close();
    }catch (SQLException ex){
      ex.printStackTrace();
    }
  }
}
