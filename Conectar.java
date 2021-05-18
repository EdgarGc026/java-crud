import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

public class Conectar {
  private final String urlHost = "jdbc:mysql://localhost/pong?"; 
  private final String urlSettings = "useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&";
  private final String urlCredentials = "user=root&password=ptrS1358"; 

  public Connection conexion(){
   Connection conectar = null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      System.out.println("Registrado");
      System.out.println("");

      conectar = DriverManager.getConnection(urlHost + urlSettings + urlCredentials);
      System.out.println(" Conectado \n");

    }catch (Exception ex){
      System.out.print(ex.getMessage());
      System.out.println("\n Error, no se pudo conectar");
    }
    return conectar;
  }

  public void cerrarConexion(Connection conectar){
    try{
      conectar.close();
    }catch (SQLException ex){
      ex.printStackTrace();
    }
  }

  public String [] [] consultarTodos(){
	ArrayList<String[]> puntajes = new ArrayList<String[]>();
	String selectAllScore = "SELECT * from pong.juego";
	ResultSet resultset = null;

	try( Connection conector = conexion();Statement stament = conector.createStatement();){

	  resultset = stament.executeQuery(selectAllScore);
	  while(resultset.next()){
	    String[] array = {resultset.getString(1),resultset.getString(2),resultset.getString(3), resultset.getString(4)};
	    puntajes.add(array);
	  }

	  String[][] array = new String[puntajes.size()][];
	  for (int i = 0; i < puntajes.size(); i++) {
	      array[i] = puntajes.get(i);
	  }

	  System.out.println(Arrays.deepToString(array));

	  cerrarConexion(conector);
	  return array;

	}catch(SQLException e){
		e.printStackTrace();
	}
	return null;
 }

  public void insertarPuntaje(int puntPlayer1, int puntPlayer2, int ganador){
	String insertScore = "INSERT INTO pong.juego (puntaje_jugador1, puntaje_jugador2, ganador) VALUES ("+ puntPlayer1 +","+ puntPlayer2 + "," + ganador + ")";
	ResultSet resultset = null;
	try( Connection conector = conexion();PreparedStatement prepareInsert = conector.prepareStatement(insertScore, Statement.RETURN_GENERATED_KEYS);){
	  	prepareInsert.execute();
		 resultset = prepareInsert.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultset.next()) {
                System.out.println("Generated: " + resultset.getString(1));
            }  
	    cerrarConexion(conector);


	}catch(SQLException e){
		e.printStackTrace();
	}
 }

}
