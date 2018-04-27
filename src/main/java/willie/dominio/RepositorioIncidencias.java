package willie.dominio;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RepositorioIncidencias extends CrudRepository<Incidencia,UUID> {
}
