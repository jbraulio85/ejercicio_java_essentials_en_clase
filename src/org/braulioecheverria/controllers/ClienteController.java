package org.braulioecheverria.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.braulioecheverria.dao.Conexion;

/**
 *
 * @author Brau
 */
public class ClienteController {
    private static ClienteController instancia;
    
    private ClienteController(){
        
    }
    
    public static synchronized ClienteController getInstancia(){
        if(instancia == null){
            instancia = new ClienteController();
        }
        return instancia;
    }
    
    public ResultSet listarClientes(){
        ResultSet respuesta = null;
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_listarClientes();");
            respuesta = sp.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}









