package ni.edu.uam.gestionproductos.dto;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) para recibir datos de producto
 * Utilizado en operaciones POST y PUT
 *
 * Ventajas de usar DTO:
 * 1. Control: Solo recibimos los datos que queremos
 * 2. Seguridad: Evitamos que el cliente modifique campos protegidos (como ID)
 * 3. Flexibilidad: Podemos tener diferentes DTOs para diferentes operaciones
 * 4. Validación: Podemos agregar anotaciones de validación
 */
public class ProductoRequestDTO {

    private String codigo;
    private String nombre;
    private BigDecimal precioVenta;
    private Integer existencia;
    private Integer categoriaId;

    // ========== Constructores ==========
    public ProductoRequestDTO() {
    }

    public ProductoRequestDTO(String codigo, String nombre, BigDecimal precioVenta,
                              Integer existencia, Integer categoriaId) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
        this.categoriaId = categoriaId;
    }

    // ========== Getters y Setters ==========
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "ProductoRequestDTO{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioVenta=" + precioVenta +
                ", existencia=" + existencia +
                ", categoriaId=" + categoriaId +
                '}';
    }
}

