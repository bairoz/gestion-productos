package ni.edu.uam.gestionproductos.controller;

import ni.edu.uam.gestionproductos.dto.ProductoRequestDTO;
import ni.edu.uam.gestionproductos.entity.Producto;
import ni.edu.uam.gestionproductos.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // ========== OPERACIONES CRUD ==========

    /**
     * GET /api/productos
     * Lista todos los productos
     */
    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    /**
     * GET /api/productos/{id}
     * Obtiene un producto por ID
     */
    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Integer id) {
        return productoService.buscarPorId(id);
    }

    /**
     * POST /api/productos
     * Crea un nuevo producto
     *
     * Ejemplo JSON:
     * {
     *     "codigo": "TEC-001",
     *     "nombre": "Teclado mecánico",
     *     "precioVenta": 75.50,
     *     "existencia": 20,
     *     "categoriaId": 2
     * }
     */
    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody ProductoRequestDTO dto) {
        Producto producto = productoService.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    /**
     * PUT /api/productos/{id}
     * Actualiza un producto existente
     *
     * Ejemplo JSON:
     * {
     *     "codigo": "TEC-002",
     *     "nombre": "Teclado inalámbrico",
     *     "precioVenta": 95.50,
     *     "existencia": 15,
     *     "categoriaId": 2
     * }
     */
    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable Integer id,
            @RequestBody ProductoRequestDTO dto) {
        return productoService.actualizar(id, dto);
    }

    /**
     * DELETE /api/productos/{id}
     * Elimina un producto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ========== CONSULTAS POR RELACIONES (Uno a Muchos) ==========

    /**
     * GET /api/productos/categoria/{categoriaId}
     * Lista todos los productos de una categoría
     *
     * Ejemplo: GET /api/productos/categoria/1
     */
    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> listarPorCategoria(@PathVariable Integer categoriaId) {
        return productoService.listarPorCategoria(categoriaId);
    }

    // ========== GESTIÓN DE ETIQUETAS (Muchos a Muchos) ==========

    /**
     * POST /api/productos/{productoId}/etiquetas/{etiquetaId}
     * Agrega una etiqueta a un producto
     *
     * Ejemplo: POST /api/productos/2/etiquetas/1
     */
    @PostMapping("/{productoId}/etiquetas/{etiquetaId}")
    public Producto agregarEtiqueta(
            @PathVariable Integer productoId,
            @PathVariable Integer etiquetaId) {
        return productoService.agregarEtiqueta(productoId, etiquetaId);
    }

    /**
     * DELETE /api/productos/{productoId}/etiquetas/{etiquetaId}
     * Elimina una etiqueta de un producto
     * RETO 1: Eliminar asociación Producto-Etiqueta
     *
     * Ejemplo: DELETE /api/productos/2/etiquetas/1
     *
     * Nota: Solo elimina la asociación, no el producto ni la etiqueta
     */
    @DeleteMapping("/{productoId}/etiquetas/{etiquetaId}")
    public Producto eliminarEtiqueta(
            @PathVariable Integer productoId,
            @PathVariable Integer etiquetaId) {
        return productoService.eliminarEtiqueta(productoId, etiquetaId);
    }

    /**
     * GET /api/productos/etiqueta/{etiquetaId}
     * RETO 2: Consulta de productos por etiqueta
     * Lista todos los productos que tienen una etiqueta específica
     *
     * Ejemplo: GET /api/productos/etiqueta/1
     */
    @GetMapping("/etiqueta/{etiquetaId}")
    public List<Producto> listarPorEtiqueta(@PathVariable Integer etiquetaId) {
        return productoService.listarPorEtiqueta(etiquetaId);
    }
}
