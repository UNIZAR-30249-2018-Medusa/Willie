package willie.dominio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface RepositorioIncidencias {

    void anyadirIncidencia(Incidencia incidencia);

    void actualizarIncidencia(Incidencia incidencia);

    void borrarIncidencia(Incidencia incidencia);

    Incidencia buscarIncidenciaNombre(String nombre);

    Incidencia buscarIncidenciaId(UUID nombre);

    ArrayList<Incidencia> buscarIncidenciasTrabajador(Trabajador trabajador);

    ArrayList<Incidencia> IncidenciasPorFecha();

    Localizacion localizarIncidencia(String nombre);



}
