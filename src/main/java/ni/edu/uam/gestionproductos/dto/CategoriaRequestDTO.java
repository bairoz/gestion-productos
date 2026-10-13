package ni.edu.uam.gestionproductos.dto;

/**
 * DTO para crear/actualizar una Categoria.
 * No incluye "id" (lo genera la BD) ni "productos" (es la lista inversa
 * de la relación Uno a Muchos; exponerla aquí permitiría que el cliente
 * intentara modificar productos desde el endpoint de categorías).
 */
public class CategoriaRequestDTO {

    private String nombre;
    private Boolean activa = true; // Cambiado de boolean a Boolean

    public CategoriaRequestDTO() {
    }

    public CategoriaRequestDTO(String nombre, Boolean activa) {
        this.nombre = nombre;
        this.activa = activa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}