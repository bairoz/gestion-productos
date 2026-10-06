package ni.edu.uam.gestionproductos.service;

import ni.edu.uam.gestionproductos.dto.ProductoRequestDTO;
import ni.edu.uam.gestionproductos.entity.Categoria;
import ni.edu.uam.gestionproductos.entity.Etiqueta;
import ni.edu.uam.gestionproductos.entity.Producto;
import ni.edu.uam.gestionproductos.repository.CategoriaRepository;
import ni.edu.uam.gestionproductos.repository.EtiquetaRepository;
import ni.edu.uam.gestionproductos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final EtiquetaRepository etiquetaRepository;

    public ProductoService(ProductoRepository productoRepository,
                           CategoriaRepository categoriaRepository,
                           EtiquetaRepository etiquetaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.etiquetaRepository = etiquetaRepository;
    }

    // ========== OPERACIONES CRUD ==========

    /**
     * Lista todos los productos
     * @return Lista de productos
     */
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    /**
     * Busca un producto por su ID
     * @param id Identificador del producto
     * @return El producto encontrado
     * @throws RuntimeException si no existe
     */
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    /**
     * Crea un nuevo producto usando DTO
     * @param dto Datos del producto
     * @return El producto guardado
     */
    public Producto guardar(ProductoRequestDTO dto) {
        // Validar que la categoría existe
        Categoria categoria = categoriaRepository
                .findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // Crear nueva instancia de Producto
        Producto producto = new Producto();
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    /**
     * Actualiza un producto existente
     * @param id Identificador del producto
     * @param dto Nuevos datos del producto
     * @return El producto actualizado
     */
    public Producto actualizar(Integer id, ProductoRequestDTO dto) {
        // Buscar producto existente
        Producto producto = buscarPorId(id);

        // Validar y obtener la nueva categoría
        Categoria categoria = categoriaRepository
                .findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // Actualizar datos
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    /**
     * Elimina un producto
     * @param id Identificador del producto
     */
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

    // ========== CONSULTAS POR RELACIONES (Uno a Muchos) ==========

    /**
     * Lista todos los productos de una categoría
     * @param categoriaId Identificador de la categoría
     * @return Lista de productos de la categoría
     */
    public List<Producto> listarPorCategoria(Integer categoriaId) {
        // Validar que la categoría existe
        if (!categoriaRepository.existsById(categoriaId)) {
            throw new RuntimeException("Categoría no encontrada");
        }
        return productoRepository.findByCategoriaId(categoriaId);
    }

    // ========== GESTIÓN DE ETIQUETAS (Muchos a Muchos) ==========

    /**
     * Agrega una etiqueta a un producto
     * @param productoId Identificador del producto
     * @param etiquetaId Identificador de la etiqueta
     * @return El producto actualizado
     */
    public Producto agregarEtiqueta(Integer productoId, Integer etiquetaId) {
        // Buscar producto
        Producto producto = buscarPorId(productoId);

        // Buscar etiqueta
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));

        // Agregar etiqueta al conjunto de etiquetas del producto
        producto.getEtiquetas().add(etiqueta);

        // Guardar cambios
        return productoRepository.save(producto);
    }

    /**
     * Elimina una etiqueta de un producto
     * RETO 1: Implementar eliminación de asociación Producto-Etiqueta
     * @param productoId Identificador del producto
     * @param etiquetaId Identificador de la etiqueta
     * @return El producto actualizado
     */
    public Producto eliminarEtiqueta(Integer productoId, Integer etiquetaId) {
        // Buscar producto
        Producto producto = buscarPorId(productoId);

        // Buscar etiqueta
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));

        // Remover etiqueta del conjunto de etiquetas del producto
        producto.getEtiquetas().remove(etiqueta);

        // Guardar cambios
        return productoRepository.save(producto);
    }

    /**
     * RETO 2: Consultar productos por etiqueta
     * Lista todos los productos que tienen una etiqueta específica
     * @param etiquetaId Identificador de la etiqueta
     * @return Lista de productos con esa etiqueta
     */
    public List<Producto> listarPorEtiqueta(Integer etiquetaId) {
        // Validar que la etiqueta existe
        if (!etiquetaRepository.existsById(etiquetaId)) {
            throw new RuntimeException("Etiqueta no encontrada");
        }
        return productoRepository.findByEtiquetasId(etiquetaId);
    }
}
