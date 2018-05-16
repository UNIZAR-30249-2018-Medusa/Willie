package willie.aplicacion;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import willie.dominio.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ControladorIncidencia {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;
    @Autowired
    RepositorioEspacios repositorioEspacios;
    @Autowired
    IncidenciaFactory incidenciaFactory;

    //TODO: Repositorio de incidencias
    @RequestMapping(value="/crearincidencia", method = RequestMethod.POST)

    public String crearIncidencia(@RequestBody RequestIncidencia incidenciaEntrante){
        Incidencia nuevaIncidencia = incidenciaFactory.crearIncidencia(incidenciaEntrante.getLatitud(),incidenciaEntrante.getLongitud(),
                incidenciaEntrante.getNombre(),incidenciaEntrante.getDescripcion(),incidenciaEntrante.isNotificacion(),incidenciaEntrante.getPlanta());
        repositorioIncidencias.anyadirIncidencia(nuevaIncidencia);


        return new String("Success");
    }

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public  @ResponseBody
    String obtenerRegistroIncidencias(){
        ArrayList<Incidencia> resultado = repositorioIncidencias.IncidenciasPorFecha();
        ArrayList<InfoIncidencia> registroDevuelto = new ArrayList<>();
        Gson gson = new Gson();
        if(resultado.isEmpty()){
            return gson.toJson(registroDevuelto);
        }else {
            for(Incidencia i : resultado){
                registroDevuelto.add(InfoIncidencia.crearInfoDeIncidencia(i));

            }
             return gson.toJson(registroDevuelto);
        }

    }


}
