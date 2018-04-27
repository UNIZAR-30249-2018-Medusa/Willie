package willie.Infraestructura;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import willie.dominio.Espacio;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioEspacios;

import java.util.Optional;


@Repository
public class RepoEspacioDominio implements RepositorioEspacios {

    @Autowired
    RepoEspacioPostGis repoEspacioPostGis;

    private Logger log = LoggerFactory.getLogger(RepoEspacioDominio.class);

    @Override
    public Optional<Espacio> ObtenerEspacioPorLoca(Localizacion localizacion) {

        Optional<Espacio> resultado;
        log.info(String.valueOf(localizacion.getLatitud())+" "+String.valueOf(localizacion.getLongitud()));
        EspacioPostGis resultadoQuery = repoEspacioPostGis.findByCoordinates(localizacion.getLongitud(),
                localizacion.getLatitud());
        if(resultadoQuery == null){
            resultado = Optional.empty();
        }else{
            resultado = Optional.of(resultadoQuery.extraeEspacio());
        }
        return resultado;
    }
}
