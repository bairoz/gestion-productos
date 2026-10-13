package ni.edu.uam.gestionproductos.dto;

/**
 * DTO para crear/actualizar un Proveedor.
 */
public class ProveedorRequestDTO {

    private String nombre;
    private String telefono;
    private String correo;
    private boolean activo = true;

    public ProveedorRequestDTO() {
    }

    public ProveedorRequestDTO(String nombre, String telefono, String correo, boolean activo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
