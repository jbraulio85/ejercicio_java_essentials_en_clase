package org.braulioecheverria.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.braulioecheverria.controllers.ClienteController;
import org.braulioecheverria.models.Cliente;

/**
 *
 * @author Brau
 */
public class ClienteView {
    private static ClienteView instancia;
    private ClienteController cc = ClienteController.getInstancia();
    
    private ClienteView(){
        
    }
    
    public static synchronized ClienteView getInstancia(){
        if(instancia == null){
            instancia = new ClienteView();
        }
        return instancia;
    }
    
    public void listarClientes(){
        ResultSet respuesta = cc.listarClientes();
        try{
            while(respuesta.next()){
                Cliente cl = new Cliente();
                cl.setNit(respuesta.getNString(1));
                cl.setApellidos(respuesta.getNString(2));
                cl.setNombres(respuesta.getNString(3));
                cl.setDireccionEnvio(respuesta.getNString(4));
                cl.setTelefono(respuesta.getInt(5));
                System.out.println(cl);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
