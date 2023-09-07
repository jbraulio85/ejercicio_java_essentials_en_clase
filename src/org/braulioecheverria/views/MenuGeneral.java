package org.braulioecheverria.views;

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
    
    public void administradorClientes(){
        System.out.println("Ingresa el número 1 para listar clientes");
        op = leer.nextInt();
        if(op == 1){
            cv.listarClientes();
        }
    }
}
