package parcial.periodo.clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author josel
 */
public class Conexion {
    private Connection Conex;
    
    public Conexion()
    {
      try
       {
              Class.forName("org.postgresql.Driver") ;
              Conex = DriverManager.getConnection("jdbc:postgresql://192.168.0.17:5432/parcial", 
                      "messi", "messi") ;
              System.out.println("La conexión es correcta");
        }
        catch(Exception e) {
            System.out.println("La conexión no es correcta");
        }
    }  

    public Connection getConex() {
        return Conex;
    }
}
