package willie.dominio;


import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RepositorioEspacios {

    Optional<Espacio> ObtenerEspacioPorLoca(Localizacion localizacion);

}
