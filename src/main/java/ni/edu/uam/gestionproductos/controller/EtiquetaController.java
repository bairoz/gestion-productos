package ni.edu.uam.gestionproductos.controller;

import ni.edu.uam.gestionproductos.entity.Etiqueta;
import ni.edu.uam.gestionproductos.service.EtiquetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    /**
     * GET /api/etiquetas
     * Lista todas las etiquetas
     */
    @GetMapping
    public List<Etiqueta> listar() {
        return etiquetaService.listar();
    }

    /**
     * GET /api/etiquetas/{id}
     * Obtiene una etiqueta por ID
     */
    @GetMapping("/{id}")
    public Etiqueta buscar(@PathVariable Integer id) {
        return etiquetaService.buscarPorId(id);
    }

    /**
     * POST /api/etiquetas
     * Crea una nueva etiqueta
     */
    @PostMapping
    public ResponseEntity<Etiqueta> guardar(@RequestBody Etiqueta etiqueta) {
        Etiqueta guardada = etiquetaService.guardar(etiqueta);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }

    /**
     * PUT /api/etiquetas/{id}
     * Actualiza una etiqueta existente
     */
    @PutMapping("/{id}")
    public Etiqueta actualizar(
            @PathVariable Integer id,
            @RequestBody Etiqueta etiqueta) {
        return etiquetaService.actualizar(id, etiqueta);
    }

    /**
     * DELETE /api/etiquetas/{id}
     * Elimina una etiqueta
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        etiquetaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
