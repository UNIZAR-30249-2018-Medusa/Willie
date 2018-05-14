package willie.Infraestructura;

import org.springframework.data.repository.CrudRepository;
import willie.dominio.Incidencia;

public interface RepoIncidenciasSpring extends CrudRepository<Incidencia,String> {

}
