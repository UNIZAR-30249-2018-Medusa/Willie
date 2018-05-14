package willie.aplicacion;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import willie.dominio.Espacio;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioEspacios;

import java.util.Optional;

@RestController
public class ControladorEspacio {
    @Autowired
    RepositorioEspacios repositorioEspacios;

    @RequestMapping(value="/espacio", method = RequestMethod.POST)
    public @ResponseBody String ObtenerInfoEspacio(@RequestBody String json){
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(json);
        JsonObject jsonObject = jsonTree.getAsJsonObject();
        System.out.println(json);
        Double lat= jsonObject.get("latitud").getAsDouble();
        Double lon = jsonObject.get("longitud").getAsDouble();
        int planta=0;
        Optional<Espacio> resultado = repositorioEspacios.ObtenerEspacioPorLoca(new Localizacion(lat,lon,planta));
        if(resultado.isPresent()){
            InfoEspacio info= new InfoEspacio(resultado.get().getPlantaEspacio(),resultado.get().getNombre(),
                    resultado.get().getEdificio(),false);
            Gson gson = new Gson();
            String representacionJSON = gson.toJson(info);
            return  representacionJSON;
        }else {
            InfoEspacio info =new InfoEspacio(0,"Exterior","Exterior",true);
            Gson gson = new Gson();
            String representacionJSON = gson.toJson(info);
            return  representacionJSON;
        }


    }
}

