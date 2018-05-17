package willie.aplicacion;

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
    public @ResponseBody InfoEspacio ObtenerInfoEspacio(@RequestBody CoordenadasMapa coord){
        System.out.println(coord);
        Double lat= coord.latitud;
        Double lon = coord.longitud;
        int planta=coord.planta;

        Optional<Espacio> resultado = repositorioEspacios.ObtenerEspacioPorLoca(new Localizacion(lat,lon,planta));
        if(resultado.isPresent()){
            InfoEspacio info= new InfoEspacio(resultado.get().getPlantaEspacio(),resultado.get().getNombre(),
                    resultado.get().getEdificio(),false,resultado.get().getId());
            return  info;
        }else {
            InfoEspacio info =new InfoEspacio(planta,"Exterior","Exterior",true,resultado.get().getId());
            return  info;
        }


    }
}

