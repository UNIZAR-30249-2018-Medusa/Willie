package willie.Infraestructura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import willie.aplicacion.CuentaAdministrador;

import java.util.Optional;

@Repository
public interface RepositorioAdministrador extends CrudRepository<CuentaAdministrador,Integer> {
    Optional<CuentaAdministrador> findByUsuario(String usuario);
}
