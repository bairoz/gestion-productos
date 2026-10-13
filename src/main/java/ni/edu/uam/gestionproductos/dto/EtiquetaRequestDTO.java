package ni.edu.uam.gestionproductos.dto;

/**
 * DTO para crear/actualizar una Etiqueta.
 * Reemplaza el uso de la entidad Etiqueta directamente en el @RequestBody
 * de EtiquetaController, evitando exponer "id" y el Set<Producto> inverso.
 */
public class EtiquetaRequestDTO {

    private String nombre;

    public EtiquetaRequestDTO() {
    }

    public EtiquetaRequestDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
