package parcial.periodo.clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class fichajes {
    private int id_fichaje;
    private String nombreJugador;
    private String apellidoJugador;
    private String nacionalidad;
    private float precioTransferencia;
    private int idEquipo;

    public fichajes(String nombreJugador, String apellidoJugador, String nacionalidad, float precioTransferencia, int idEquipo) {
        this.nombreJugador = nombreJugador;
        this.apellidoJugador = apellidoJugador;
        this.nacionalidad = nacionalidad;
        this.precioTransferencia = precioTransferencia;
        this.idEquipo = idEquipo;
    }

    public fichajes(int id_fichaje, String nombreJugador, String apellidoJugador, String nacionalidad, float precioTransferencia, int idEquipo) {
        this.id_fichaje = id_fichaje;
        this.nombreJugador = nombreJugador;
        this.apellidoJugador = apellidoJugador;
        this.nacionalidad = nacionalidad;
        this.precioTransferencia = precioTransferencia;
        this.idEquipo = idEquipo;
    }
    
    public fichajes() {
    }
    
    
    

    public void insert(Connection conex, String pNombre,String pApellido,String pNacionalidad, float pPrecioTrans, int id_equipo)
    {
        try
        {
            String query = "call insertarFichajes(?,?,?,?,?)";
            CallableStatement cs=conex.prepareCall(query);
            cs.setString(1, pNombre); 
            cs.setString(2, pApellido); 
            cs.setString(3, pNacionalidad); 
            cs.setFloat(4, pPrecioTrans);
            cs.setInt(5, id_equipo);
            cs.execute();
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public void deleteFichaje(Connection conex, int id_fichaje)
    {
        try
        {
            String query = "call eliminarFichaje(?)";
            CallableStatement cs=conex.prepareCall(query);
            cs.setInt(1, id_fichaje);
            cs.execute();
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public void update(Connection conex, String pNombre,String pApellido,String pNacionalidad, float pPrecioTrans)
    {
        try
        {
            String query = "call ActualizarFichajes(?,?,?,?)";
            CallableStatement cs=conex.prepareCall(query);
            cs.setString(1, pNombre); 
            cs.setString(2, pApellido); 
            cs.setString(3, pNacionalidad); 
            cs.setFloat(4, pPrecioTrans);
            cs.execute();
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public ResultSet getTodo(Connection conex) {
        ResultSet rs = null;
        try {
            Statement stmt = conex.createStatement();
            String query = "SELECT * FROM fichajes order by id_fichaje;";
            rs = stmt.executeQuery(query);
        } catch (Exception ee) {
        }

        return rs;
    }
    
    public ResultSet getTodoID(Connection conex, int id_equipo) {
        ResultSet rs = null;
        try {
            Statement stmt = conex.createStatement();
            String query = "SELECT * FROM fichajes where id_equipo="+id_equipo+" order by id_fichaje;";
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
        }

        return rs;
    }
    
    public int getID_fichaje(Connection conex, int id_Equipo)
    {
        ResultSet rs=null;
        this.id_fichaje=0;
        try
        {
          Statement stmt = conex.createStatement() ;
          String query = "SELECT max(id_fichaje) FROM fichajes where id_equipo="
                         + Integer.toString(id_Equipo)+";";
          rs = stmt.executeQuery(query);
          if(rs.next())
          {
              this.id_fichaje= rs.getInt(1);
          }
        }
        catch(Exception ee) {
            System.out.println(ee);
        }
        return this.id_fichaje;
    }

    
    public int getId_fichaje() {
        return id_fichaje;
    }

    public void setId_fichaje(int id_fichaje) {
        this.id_fichaje = id_fichaje;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getPrecioTransferencia() {
        return precioTransferencia;
    }

    public void setPrecioTransferencia(float precioTransferencia) {
        this.precioTransferencia = precioTransferencia;
    }  
    
    
}
