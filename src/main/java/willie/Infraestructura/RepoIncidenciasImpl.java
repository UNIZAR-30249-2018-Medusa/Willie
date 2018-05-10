package willie.Infraestructura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import willie.dominio.*;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class RepoIncidenciasImpl implements RepositorioIncidencias {

    @Override
    public void anyadirIncidencia(String descripcion, String nombre, Localizacion localizacion, Trabajador trabajador) {

    }

    @Override
    public void actualizarIncidencia(String descripcion, String nombre, Localizacion localizacion, Trabajador trabajador) {

    }

    @Override
    public void borrarIncidencia(String nombre) {

    }

    @Override
    public void cambiarEstadoIncidencia(String nombre, Estado estado) {

    }

    @Override
    public Incidencia buscarIncidenciaNombre(String nombre) {
        return null;
    }

    @Override
    public ArrayList<Incidencia> buscarIncidenciasTrabajador(Trabajador trabajador) {
        return null;
    }

    @Override
    public Localizacion localizarIncidencia(String nombre) {
        return null;
    }
}