package willie.Infraestructura;

import org.springframework.beans.factory.annotation.Autowired;
import willie.dominio.Espacio;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioEspacios;

import java.util.Optional;


public class RepoEspacioDominio implements RepositorioEspacios {

    @Autowired
    RepoEspacioPostGis repoEspacioPostGis;

    @Override
    public Optional<Espacio> ObtenerEspacioPorLoca(Localizacion localizacion) {

        Optional<Espacio> resultado;
        EspacioPostGis resultadoQuery = repoEspacioPostGis.findByCoordinates(String.valueOf(localizacion.getLatitud()),
                String.valueOf(localizacion.getLongitud()), localizacion.getPlanta());
        if(resultadoQuery == null){
            resultado = Optional.empty();
        }else{
            resultado = Optional.of(resultadoQuery.extraeEspacio());
        }
        return resultado;
    }
}
