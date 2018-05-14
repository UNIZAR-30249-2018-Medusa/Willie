package willie.Infraestructura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import willie.dominio.*;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class RepoIncidenciasImpl implements RepositorioIncidencias {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void anyadirIncidencia(String descripcion, String nombre,
                                  Localizacion localizacion, Trabajador trabajador) {

        final String SQLstatement = "INSERT INTO public.incidencia (" +
                "descripcion, nombre, localizacion, trabajador)" +
                " VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(SQLstatement, descripcion, nombre,
                localizacion, trabajador);

    }

    @Override
    public void actualizarIncidencia(String descripcion, String nombre,
                                     Localizacion localizacion, Trabajador trabajador) {

        final String SQLstatement = "UPDATE public.incidencia SET " +
                "descripcion = ?, localizacion = ?, trabajador = ? " +
                "WHERE nombre = ?";

        jdbcTemplate.update(SQLstatement, descripcion,
                localizacion, trabajador, nombre);

    }

    @Override
    public void borrarIncidencia(String nombre) {

        final String SQLstatement = "DELETE FROM public.incidencia " +
                "WHERE nombre = ?";

        jdbcTemplate.update(SQLstatement, nombre);

    }

    @Override
    public void cambiarEstadoIncidencia(String nombre, Estado estado) {

        final String SQLstatement = "UPDATE public.incidencia SET " +
                "estado = ? WHERE nombre = ?";

        jdbcTemplate.update(SQLstatement, estado, nombre);

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