package org.braulioecheverria.models;

/**
 *
 * @author Brau
 */
public class Cliente {
    private String nit;
    private String apellidos;
    private String nombres;
    private String direccionEnvio;
    private int telefono;

    public Cliente() {
    }

    public Cliente(String nit, String apellidos, String nombres, String direccionEnvio, int telefono) {
        this.nit = nit;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccionEnvio = direccionEnvio;
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    @Override
    public String toString() {
        return 
                "{ " + "\n" +
                "   nit: " + nit + ", " + "\n" + 
                "   Dirección de envio: " + direccionEnvio + ", " + "\n" + 
                "   Apellidos: " + apellidos + ", " + "\n" + 
                "   Nombres: " + nombres + ", " + "\n" + 
                "   Teléfono: " + telefono + ", " + "\n" + 
                "}";
    }
    
   
    
}
