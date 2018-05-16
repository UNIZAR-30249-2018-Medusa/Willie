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

    //TODO: Repositorio de incidencias
    @RequestMapping(value="/crearincidencia", method = RequestMethod.POST)

    public String crearIncidencia(@RequestBody RequestIncidencia incidenciaEntrante){
        Localizacion localizacion = new Localizacion(incidenciaEntrante.getLatitud(),incidenciaEntrante.getLongitud(),incidenciaEntrante.getPlanta());
        //TODO: Obtener un espacion dadas unas coordenadas a través de un servicio de dominio
        Optional<Espacio> espacioResultado = repositorioEspacios.ObtenerEspacioPorLoca(localizacion);
        boolean exterior = true;
        String idespacio = "exterior";
        if(espacioResultado.isPresent()){
            exterior=false;
            idespacio=espacioResultado.get().getNombre();
        }
        IncidenciaFactory incidenciaFactory = new IncidenciaFactory();
        Incidencia nuevaIncidencia = incidenciaFactory.crearIncidencia(incidenciaEntrante.getLatitud(),incidenciaEntrante.getLongitud(),
                incidenciaEntrante.getNombre(),incidenciaEntrante.getDescripcion(),incidenciaEntrante.isNotificacion(),idespacio);

           System.out.println("VEAMos que incidencia mete");
        System.out.println(nuevaIncidencia.getId());
        System.out.println(nuevaIncidencia.getDescripcion());
        System.out.println(nuevaIncidencia.getEstado());
        System.out.println(nuevaIncidencia.getHoraFechaCreada());
        System.out.println(nuevaIncidencia.esNotificacion());
        System.out.println(nuevaIncidencia.getCodigoCancelacion());
        System.out.println(nuevaIncidencia.getLocalizacion().getLatitud());
        System.out.println(nuevaIncidencia.getIdespacio());
        System.out.println(nuevaIncidencia.getNombreIncidencia());
        System.out.println("-----------------------------------------");


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
