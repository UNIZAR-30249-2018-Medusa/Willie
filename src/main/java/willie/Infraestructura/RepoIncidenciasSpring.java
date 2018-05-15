package willie.Infraestructura;

import org.springframework.data.repository.CrudRepository;
import willie.dominio.Incidencia;

import java.util.ArrayList;
import java.util.UUID;

public interface RepoIncidenciasSpring extends CrudRepository<Incidencia,String> {

    Incidencia findByNombreIncidencia(String nombre);
    void deleteByNombreIncidencia(String nombre);
    Incidencia findById(UUID id);
    ArrayList<Incidencia> findAllByOrderByHoraFechaCreadaDesc();
    void deleteById(UUID id);

}
