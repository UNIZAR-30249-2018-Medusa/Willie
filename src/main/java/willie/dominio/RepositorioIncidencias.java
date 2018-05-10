package willie.dominio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface RepositorioIncidencias {

    void anyadirIncidencia(String descripcion, String nombre, Localizacion localizacion, Trabajador trabajador);

    void actualizarIncidencia(String descripcion, String nombre, Localizacion localizacion, Trabajador trabajador);

    void borrarIncidencia(String nombre);

    void cambiarEstadoIncidencia(String nombre, Estado estado);

    Incidencia buscarIncidenciaNombre(String nombre);

    ArrayList<Incidencia> buscarIncidenciasTrabajador(Trabajador trabajador);

    Localizacion localizarIncidencia(String nombre);

}
