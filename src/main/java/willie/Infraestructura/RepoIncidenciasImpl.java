package willie.Infraestructura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import willie.dominio.Incidencia;
import willie.dominio.RepositorioIncidencias;

import java.util.UUID;

@Repository
public interface RepoIncidenciasImpl extends RepositorioIncidencias {
}
