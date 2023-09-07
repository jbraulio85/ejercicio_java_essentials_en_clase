package org.braulioecheverria.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.braulioecheverria.controllers.ClienteController;
import org.braulioecheverria.models.Cliente;
import org.braulioecheverria.utils.Lector;

/**
 *
 * @author Brau
 */
public class ClienteView {
    private static ClienteView instancia;
    private ClienteController cc = ClienteController.getInstancia();
    private Scanner leer = Lector.getInstancia();
    private Cliente cl = new Cliente();
    
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
    
    public void buscarCliente(){
        System.out.println("Ingresa el nit del cliente a buscar");
        leer.nextLine();
        String nit = leer.nextLine();
        cl = cc.buscarCliente(nit);
        if(cl.getNit() != null){
            System.out.println(cl);
        }else{
            System.out.println("No se encontró el cliente con el nit: " + nit);
        }
    }
    
    public void eliminarCliente(){
        System.out.println("Ingrese el nit del cliente a eliminar");
        leer.nextLine();
        String nit = leer.nextLine();
        cc.eliminarCliente(nit);
        System.out.println("Cliente eliminado exitosamente");
    }
    
    public void agregarCliente(){
        System.out.println("Ingresa el nit");
        leer.nextLine();
        String nit = leer.nextLine();
        System.out.println("Escribe los apellidos");
        String apellidos = leer.nextLine();
        System.out.println("Escribe los nombrs");
        String nombres = leer.nextLine();
        System.out.println("Escribe la dirección de envío");
        String direccionEnvio = leer.nextLine();
        int telefono = 0;
         boolean validInput = false;
         while(!validInput){
            try{
                 System.out.println("Ingresa el número de teléfono");
                  telefono = leer.nextInt();
                  leer.nextLine();
                  validInput = true;
            }catch(InputMismatchException e){
                System.out.println("Error: Ingresaste un carácter inválido, ingesa un número de teléfono válido");
                leer.next();
            }
        }
        cc.agregarCliente(nit, apellidos, nombres, direccionEnvio, telefono);
        cl = cc.buscarCliente(nit);
        if(cl.getNit().equals(nit)){
            System.out.println("Cliente almacenado exitosamente!!!");
        }else{
            System.out.println("NO se pudo resgistrar el cliente");
        }
    }
    
    public void actualizarCliente(){
        System.out.println("Ingresa el nit del cliente a actualizar");
        leer.nextLine();
        String nit = leer.nextLine();
        cl =  cc.buscarCliente(nit);
        if(cl.getNit().equals(nit)){
            System.out.println("Ingresa los apellidos:");
            String apellidos = leer.nextLine();
            System.out.println("Ingresa los nombres:");
            String nombres = leer.nextLine();
            System.out.println("Ingresa la dirección de envío");
            String direccionEnvio = leer.nextLine();
            System.out.println("Ingresa el teléfono:");
            int telefono = leer.nextInt();
            cc.actualizarCliente(nit, apellidos, nombres, direccionEnvio, telefono);
            System.out.println("Registro actualizado exitosamente");
        }else{
            System.out.println("No se encontró el cliente con el nit " + nit);
        }
    }
}
