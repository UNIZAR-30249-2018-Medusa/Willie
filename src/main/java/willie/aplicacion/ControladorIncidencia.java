package willie.aplicacion;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import willie.dominio.Incidencia;
import willie.dominio.IncidenciaFactory;
import willie.dominio.RepositorioIncidencias;

@RestController
public class ControladorIncidencia {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;
    //TODO: Repositorio de incidencias
    @RequestMapping(value="/crearincidencia", method = RequestMethod.POST)
    public String CrearIncidencia(@RequestBody String json){
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(json);
        JsonObject jsonObject = jsonTree.getAsJsonObject();
        String nombre = jsonObject.get("nombre").getAsString();
        String descripcion = jsonObject.get("descripcion").getAsString();
        Double latitud = (jsonObject.get("valorlat").getAsDouble());
        Double longitud = (jsonObject.get("valorlong").getAsDouble());
        RequestIncidencia incidenciaEntrante=new RequestIncidencia(descripcion,nombre,latitud,longitud,true,0);

        IncidenciaFactory incidenciaFactory = new IncidenciaFactory();
        Incidencia nuevaIncidencia = incidenciaFactory.crearIncidencia(incidenciaEntrante.getNombre(),
                incidenciaEntrante.getLatitud(),incidenciaEntrante.getLongitud(),incidenciaEntrante.getDescripcion(),
                incidenciaEntrante.isNotificacion(),incidenciaEntrante.getPlanta());
        repositorioIncidencias.anyadirIncidencia(nuevaIncidencia);
        return new String("Success");
    }
}
