package willie.Infraestructura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import willie.dominio.Incidencia;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioIncidencias;
import willie.dominio.Trabajador;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class RepoIncidenciasImpl implements RepositorioIncidencias {

    @Autowired
    RepoIncidenciasSpring repoIncidenciasSpring;

    @Override
    @Transactional
    public void anyadirIncidencia(Incidencia incidencia) {
        repoIncidenciasSpring.save(incidencia);

    }

    @Override
    public void actualizarIncidencia(Incidencia incidencia) {
        repoIncidenciasSpring.save(incidencia);
    }

    @Override
    public void borrarIncidencia(Incidencia incidencia) {

        repoIncidenciasSpring.deleteById(incidencia.getId());

    }

    @Override
    public Incidencia buscarIncidenciaNombre(String nombre) {
        return repoIncidenciasSpring.findByNombreIncidencia(nombre);
    }

    @Override
    public Incidencia buscarIncidenciaId(UUID nombre) {
        return repoIncidenciasSpring.findById(nombre);
    }

    @Override
    public ArrayList<Incidencia> buscarIncidenciasTrabajador(Trabajador trabajador) {
        return null;
    }

    @Override
    public ArrayList<Incidencia> IncidenciasPorFecha() {
        return repoIncidenciasSpring.findAllByOrderByHoraFechaCreadaDesc();
    }

    @Override
    public Localizacion localizarIncidencia(String nombre) {
        return null;
    }
}