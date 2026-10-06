package ni.edu.uam.gestionproductos.repository;

import ni.edu.uam.gestionproductos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Resuelve el error 1: Búsqueda por ID de categoría
    List<Producto> findByCategoriaId(Integer categoriaId);

    // Resuelve el error 4: Búsqueda por ID de etiqueta (Reto 2)
    List<Producto> findByEtiquetasId(Integer etiquetaId);
}