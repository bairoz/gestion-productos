package ni.edu.uam.gestionproductos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "etiqueta")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Relación inversa Muchos a Muchos
    // JsonIgnore para evitar referencias circulares en JSON
    @ManyToMany(mappedBy = "etiquetas")
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    // ========== Constructores ==========
    public Etiqueta() {
    }

    public Etiqueta(String nombre) {
        this.nombre = nombre;
    }

    // ========== Getters y Setters ==========
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}