package org.braulioecheverria.views;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.braulioecheverria.utils.Lector;

/**
 *
 * @author Brau
 */
public class MenuGeneral {
    private final Scanner leer = Lector.getInstancia();
    private int op = 0;
    private ClienteView cv = ClienteView.getInstancia();
    
    public void arranque(){
        try{
            boolean flag = false;
            while(!flag){
                System.out.println("Bienvenido al sistema de adiminstración de la tienda El Zope" + "\n" +
                        "Ingresa el número de la opción que deseas realizar." + "\n" +
                        "1. Administración de clientes." + "\n" +
                        "0. Terminar programa");
                op = leer.nextInt();
                switch(op){
                    case  1:
                        administradorClientes();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: Ingresaste un carácter inválido, ingresa un número por favor!!!");
        }
    }
    
    private void administradorClientes(){
        try{
            boolean flag = false;
            while(!flag){
                System.out.println("Bienvenido al administrador de cliente" + "\n" +
                        "Ingresa el número de la opción que deseas realizar." + "\n" +
                        "1. Listar Clientes." + "\n" + 
                        "2. Buscar Cliente." + "\n" + 
                        "3. Eliminar Cliente." + "\n" + 
                        "4. Agregar Cliente." + "\n" + 
                        "5. Actualizar Cliente." + "\n" + 
                        "0. Regresar al menú anterior");
                op = leer.nextInt();
                switch(op){
                    case  1:
                        cv.listarClientes();
                        break;
                    case 2:
                        cv.buscarCliente();
                        break;
                    case 3:
                        cv.eliminarCliente();
                        break;
                    case 4:
                        cv.agregarCliente();
                        break;
                    case 5:
                        cv.actualizarCliente();
                        break;
                    case 0:
                        arranque();
                        break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: Ingresaste un carácter inválido, ingresa un número por favor!!!");
        }
    }
}
