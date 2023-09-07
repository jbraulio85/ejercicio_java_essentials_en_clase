package org.braulioecheverria.dao;
import java.sql.*;

/**
 *
 * @author Brau
 */
public class Conexion {
    private Connection conexion;
    private static Conexion instancia;
    
    private Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection
                                ("jdbc:mysql://localhost:3306/dbtiendaelectronicos?useSSL=false","jecheverria","root");
        }catch(ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException error){
            System.out.println(error.getMessage());
        }
    }
    
    public static synchronized Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
