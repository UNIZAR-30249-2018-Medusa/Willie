package willie.aplicacion;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import willie.dominio.Incidencia;
import willie.dominio.IncidenciaFactory;

@RestController
public class ControladorIncidencia {

    //TODO: Repositorio de incidencias
    @PostMapping("/incidencia")
    String CrearIncidencia(RequestIncidencia incidenciaEntrante){

        Incidencia nuevaIncidencia = IncidenciaFactory.crearIncidencia(incidenciaEntrante.latitud,
                incidenciaEntrante.longitud,incidenciaEntrante.descripcion,incidenciaEntrante.notificacion);
        return new String("Success");
    }
}
