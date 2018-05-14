package willie.Infraestructura;

import org.springframework.data.repository.CrudRepository;
import willie.dominio.Incidencia;

import java.util.UUID;

public interface RepoIncidenciasSpring extends CrudRepository<Incidencia,String> {

    Incidencia findByNombreIncidencia(String nombre);
    void deleteByNombreIncidencia(String nombre);
    Incidencia findById(UUID id);

}
