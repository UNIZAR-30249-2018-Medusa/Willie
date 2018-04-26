package willie.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import willie.dominio.Incidencia;
import willie.dominio.IncidenciaFactory;
import willie.dominio.RepositorioEspacios;

@RestController
public class ControladorIncidencia {

    @Autowired
    RepositorioEspacios repositorioEspacios;
    //TODO: Repositorio de incidencias
    @PostMapping("/incidencia")
    public String CrearIncidencia(RequestIncidencia incidenciaEntrante){

        IncidenciaFactory incidenciaFactory = new IncidenciaFactory();
        Incidencia nuevaIncidencia = incidenciaFactory.crearIncidencia(incidenciaEntrante.getLatitud(),
                incidenciaEntrante.getLongitud(),incidenciaEntrante.getDescripcion(),incidenciaEntrante.isNotificacion(),
                incidenciaEntrante.getPlanta());
        return new String("Success");
    }
}
