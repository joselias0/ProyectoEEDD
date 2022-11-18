package parcial.periodo.clases;


import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class equipoDeFutbol {
    private int id_equipo;
    private String nombre;
    private String pais;
    private String nombreEstadio;
    private float gastoFichajes;
    private ArrayList<fichajes> lFichaje;

    public equipoDeFutbol() {
        this.lFichaje=new ArrayList<>();

    }

    public equipoDeFutbol(String pNombre, String pPais, String pNombreEstadio, float pGastoFichajes) {
        this.nombre=pNombre;
        this.pais=pPais;
        this.nombreEstadio=pNombreEstadio;
        this.gastoFichajes=pGastoFichajes;
        this.lFichaje=new ArrayList<>();

    }
    
    
    
    //nombre, pais, nombreEstadio
    public void insert(Connection conex, String pNombre, String pPais, String pNombreEstadio)
    {
        try
        {
            String query = "call insertarEquipo(?,?,?)";
            CallableStatement cs=conex.prepareCall(query);
            cs.setString(1, pNombre);
            cs.setString(2, pPais);
            cs.setString(3, pNombreEstadio);   
            cs.execute();
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
    
        public void delete(Connection conex, int idEquipo)
    {
        try
        {
            String query = "call eliminarEquipo(?)";
            CallableStatement cs=conex.prepareCall(query);
            cs.setInt(1, idEquipo);
            cs.execute();
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public ResultSet getTodo(Conexion pCon) {
        ResultSet rs = null;
        try {
            Statement stmt = pCon.getConex().createStatement();
            String query = "SELECT * FROM equipo order by id_equipo asc;";
            rs = stmt.executeQuery(query);
        } catch (Exception ee) {
        }

        return rs;
    }
    
    //fichajes
    public void addFichaje(Connection conex, String pNombre,String pApellido,String pNacionalidad, float pPrecioTrans, int id_equipo) {
        fichajes ficha = new fichajes();
        ficha.insert(conex, pNombre, pApellido, pNacionalidad, pPrecioTrans, id_equipo);
        this.push(conex);

    }
    
    public void deleteFichaje(Connection conex, int id_fichaje)
    {
        fichajes ficha=new fichajes();
        ficha.deleteFichaje(conex, id_fichaje);
    }
    

    
    public void push(Connection conex){
        this.lFichaje.clear();
        fichajes ficha= new fichajes();
        ficha.getTodo(conex);
        
        try
        {
           ResultSet rs= this.buscarFichaje(conex);  
            while (rs.next()) {
                int id_fichaje= rs.getInt("id_fichaje");
                String nombre = rs.getString("nombreJugador");
                String apellido = rs.getString("apellidoJugador");
                String nacionalidad = rs.getString("nacionalidad");
                float precioTrans = rs.getInt("precioTransferencia");
                int id_equipo = rs.getInt("id_equipo");
                //--->De la consulta obtienes el apellido
                fichajes fichaInser=new fichajes(id_fichaje, nombre, apellido, nacionalidad, precioTrans, id_equipo);
                this.lFichaje.add(fichaInser);

            }
          
        }
        catch(Exception e) {}
    }
    
    
    public ResultSet buscarFichaje(Connection conex)
    {
        fichajes ficha= new fichajes();
        return ficha.getTodo(conex);
    }
    
    public ResultSet buscarFichajeID(Connection conex, int id_equipo)
    {
        fichajes ficha= new fichajes();
        return ficha.getTodoID(conex, id_equipo);
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public double getGastoFichajes() {
        return gastoFichajes;
    }

    public void setGastoFichajes(float gastoFichajes) {
        this.gastoFichajes = gastoFichajes;
    }
}
