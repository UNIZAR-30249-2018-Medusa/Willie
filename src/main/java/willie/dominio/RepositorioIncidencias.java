package willie.dominio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioIncidencias extends CrudRepository<Incidencia,UUID> {}
