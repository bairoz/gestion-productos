package ni.edu.uam.gestionproductos.service;

import ni.edu.uam.gestionproductos.entity.Etiqueta;
import ni.edu.uam.gestionproductos.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    // ========== OPERACIONES CRUD ==========

    /**
     * Lista todas las etiquetas
     * @return Lista de etiquetas
     */
    public List<Etiqueta> listar() {
        return etiquetaRepository.findAll();
    }

    /**
     * Busca una etiqueta por su ID
     * @param id Identificador de la etiqueta
     * @return La etiqueta encontrada
     * @throws RuntimeException si no existe
     */
    public Etiqueta buscarPorId(Integer id) {
        return etiquetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
    }

    /**
     * Crea una nueva etiqueta
     * @param etiqueta Etiqueta a guardar
     * @return La etiqueta guardada
     */
    public Etiqueta guardar(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    /**
     * Actualiza una etiqueta existente
     * @param id Identificador de la etiqueta
     * @param etiqueta Datos actualizados
     * @return La etiqueta actualizada
     */
    public Etiqueta actualizar(Integer id, Etiqueta etiqueta) {
        Etiqueta etiquetaExistente = buscarPorId(id);
        etiquetaExistente.setNombre(etiqueta.getNombre());
        return etiquetaRepository.save(etiquetaExistente);
    }

    /**
     * Elimina una etiqueta
     * @param id Identificador de la etiqueta
     */
    public void eliminar(Integer id) {
        etiquetaRepository.deleteById(id);
    }
}
