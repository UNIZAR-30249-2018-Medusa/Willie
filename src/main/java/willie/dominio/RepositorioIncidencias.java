
package willie.dominio;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioIncidencias {

    void anyadirIncidencia(Incidencia i);

    void actualizarIncidencia(Incidencia i,Trabajador trabajador);

    void borrarIncidencia(Incidencia i);

    void cambiarEstadoIncidencia(Incidencia i, Estado estado);

    Incidencia buscarIncidenciaNombre(Incidencia i);

    ArrayList<Incidencia> buscarIncidenciasTrabajador(Trabajador trabajador);

    Localizacion localizarIncidencia(String i);

}
