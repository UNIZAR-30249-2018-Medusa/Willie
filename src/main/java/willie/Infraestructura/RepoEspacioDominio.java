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
    RepoEspacioSpring repoEspacioSpring;

    private Logger log = LoggerFactory.getLogger(RepoEspacioDominio.class);

    @Override
    public Optional<Espacio> ObtenerEspacioPorLoca(Localizacion localizacion) {

        Optional<Espacio> resultado;
        log.info(String.valueOf(localizacion.getLatitud())+" "+String.valueOf(localizacion.getLongitud()));
        EspacioPostGis resultadoQuery = null;
        switch (localizacion.getPlanta()){
            case 0:
                resultadoQuery = repoEspacioSpring.findByCoordinatesPlanta0(localizacion.getLongitud(),
                        localizacion.getLatitud());
                break;
            case 1:
                resultadoQuery = repoEspacioSpring.findByCoordinatesPlanta1(localizacion.getLongitud(),
                        localizacion.getLatitud());
                break;
            case 2:
                resultadoQuery = repoEspacioSpring.findByCoordinatesPlanta2(localizacion.getLongitud(),
                        localizacion.getLatitud());
                break;
            case 3:
                resultadoQuery = repoEspacioSpring.findByCoordinatesPlanta3(localizacion.getLongitud(),
                        localizacion.getLatitud());
                break;
            case 4:
                resultadoQuery = repoEspacioSpring.findByCoordinatesPlanta4(localizacion.getLongitud(),
                        localizacion.getLatitud());
                break;
            case -1:
                resultadoQuery = repoEspacioSpring.findByCoordinatesPlantaSot(localizacion.getLongitud(),
                        localizacion.getLatitud());
                break;
        }
        if(resultadoQuery == null){
            log.info("estoy en null");
            resultado = Optional.empty();
        }else{
            log.info("estoy en si");
            resultado = Optional.of(resultadoQuery.extraeEspacio());
        }
        return resultado;
    }
}
