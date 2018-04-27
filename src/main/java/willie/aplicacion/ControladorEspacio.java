package willie.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import willie.dominio.Espacio;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioEspacios;

import java.util.Optional;

@RestController
public class ControladorEspacio {
    @Autowired
    RepositorioEspacios repositorioEspacios;

    @RequestMapping(value = "/espacio", method = RequestMethod.GET)
    public InfoEspacio ObtenerInfoEspacio(@RequestParam double lat, @RequestParam double lon, @RequestParam int planta){

        Optional<Espacio> resultado = repositorioEspacios.ObtenerEspacioPorLoca(new Localizacion(lat,lon,planta));
        if(resultado.isPresent()){
            return new InfoEspacio(resultado.get().getPlantaEspacio(),resultado.get().getNombre(),
                    resultado.get().getEdificio(),false);
        }else {
            return new InfoEspacio(0,"Exterior","Exterior",true);
        }

    }
}
