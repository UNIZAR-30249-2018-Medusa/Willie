package willie.Infraestructura;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import willie.dominio.*;

import java.util.ArrayList;

@Repository
public class RepoIncidenciasImpl implements RepositorioIncidencias {
    @Autowired
    RepoIncidenciaPostGis repoIncidenciaPostGis;
    private Logger log = LoggerFactory.getLogger(RepoIncidenciasImpl.class);

    @Override
    public void anyadirIncidencia(Incidencia incidencia) {

       repoIncidenciaPostGis.save(incidencia.getCodigoCancelacion(),
               incidencia.getDescripcion(),incidencia.getexterior(),incidencia.getEstado().toString(),
               incidencia.gethoraFechaCreada(),incidencia.getTrabajador().getNombre(),incidencia.getCodigoCancelacion(),
               incidencia.getNombreIncidencia());


    }

    @Override
    public void actualizarIncidencia(Incidencia i, Trabajador trabajador) {

    }

    @Override
    public void borrarIncidencia(Incidencia i) {

    }

    @Override
    public void cambiarEstadoIncidencia(Incidencia i, Estado estado) {

    }

    @Override
    public Incidencia buscarIncidenciaNombre(Incidencia i) {
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