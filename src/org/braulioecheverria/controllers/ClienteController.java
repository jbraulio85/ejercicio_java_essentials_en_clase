package org.braulioecheverria.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.braulioecheverria.dao.Conexion;
import org.braulioecheverria.models.Cliente;

/**
 *
 * @author Brau
 */
public class ClienteController {
    private static ClienteController instancia;
    private Cliente cl = new Cliente();
    
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
    
    public Cliente buscarCliente(String nit){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_buscarCliente(?)");
            sp.setString(1, nit);
            ResultSet respuesta = sp.executeQuery();
            while(respuesta.next()){
                cl.setNit(respuesta.getNString(1));
                cl.setApellidos(respuesta.getNString(2));
                cl.setNombres(respuesta.getNString(3));
                cl.setDireccionEnvio(respuesta.getNString(4));
                cl.setTelefono(respuesta.getInt(5));
            }
            respuesta.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return cl;
    }
    
    public void eliminarCliente(String nit){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_eliminarClientes(?);");
            sp.setString(1, nit);
            sp.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void agregarCliente(String nit, String apellidos, String nombres, String direccionEnvio, int telefono){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_agregarCliente(?,?,?,?,?);");
            sp.setString(1, nit);
            sp.setString(2, apellidos);
            sp.setString(3, nombres);
            sp.setString(4, direccionEnvio);
            sp.setInt(5, telefono);
            sp.execute();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizarCliente(String nit, String apellidos, String nombres, String direccionEnvio, int telefono){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_actualizarCliente(?,?,?,?,?);");
            sp.setString(1, nit);
            sp.setString(2, apellidos);
            sp.setString(3, nombres);
            sp.setString(4, direccionEnvio);
            sp.setInt(5, telefono);
            sp.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}









