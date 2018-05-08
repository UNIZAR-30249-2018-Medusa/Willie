package willie.Infraestructura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import willie.dominio.Incidencia;
import willie.dominio.RepositorioIncidencias;
import java.util.UUID;

@Repository
public interface RepoIncidenciasImpl implements RepositorioIncidencias {

    @Override
    void anyadirIncidencia(String descripcion, String nombre, Localizacion localizacion, Trabajador trabajador)
    {

    }

    @Override
    void actualizarIncidencia(String descripcion, String nombre, Localizacion localizacion, Trabajador trabajador)
    {

    }

    @Override
    void borrarIncidencia(String nombre)
    {

    }

    @Override
    void cambiarEstadoIncidencia(String nombre, Estado estado)
    {

    }

    @Override
    Incidencia buscarIncidenciaNombre(String nombre)
    {

    }

    @Override
    ArrayList<Incidencia> buscarIncidenciasTrabajador(Trabajador trabajador)
    {

    }

    @Override
    Localizacion localizarIncidencia(String nombre)
    {

    }
}