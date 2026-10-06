package ni.edu.uam.gestionproductos.repository;

import ni.edu.uam.gestionproductos.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
    // Los métodos básicos (findAll, findById, save, delete)
    // ya están heredados de JpaRepository
}