package willie.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import willie.dominio.Incidencia;
import willie.dominio.IncidenciaFactory;
import willie.dominio.RepositorioEspacios;
import willie.dominio.RepositorioIncidencias;

@RestController
public class ControladorIncidencia {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;
    //TODO: Repositorio de incidencias
    @RequestMapping(value="/incidencia", method = RequestMethod.POST)
    public String crearIncidencia(RequestIncidencia incidenciaEntrante){

        IncidenciaFactory incidenciaFactory = new IncidenciaFactory();
        Incidencia nuevaIncidencia = incidenciaFactory.crearIncidencia(incidenciaEntrante.getLatitud(),
                incidenciaEntrante.getLongitud(),incidenciaEntrante.getNombre(),incidenciaEntrante.getDescripcion(),incidenciaEntrante.isNotificacion(),
                incidenciaEntrante.getPlanta());
        return new String("Success");
    }
//    @RequestMapping(value = "/registro", method = RequestMethod.GET)
//    public InfoIncidencia[] obtenerRegistroIncidencias(){
//
//        repositorioIncidencias
//    }
}
