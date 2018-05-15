package willie.dominio;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface RepositorioIncidencias {
    @Transactional
    void anyadirIncidencia(Incidencia incidencia);

    void actualizarIncidencia(Incidencia incidencia);

    void borrarIncidencia(Incidencia incidencia);

    Incidencia buscarIncidenciaNombre(String nombre);

    Incidencia buscarIncidenciaId(UUID nombre);

    ArrayList<Incidencia> buscarIncidenciasTrabajador(Trabajador trabajador);

    ArrayList<Incidencia> IncidenciasPorFecha();

    Localizacion localizarIncidencia(String nombre);



}