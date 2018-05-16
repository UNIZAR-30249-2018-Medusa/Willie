package willie.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class IncidenciaFactory {

    @Autowired
    RepositorioEspacios repositorioEspacios;

    public Incidencia crearIncidencia(Double latitud, Double longitud, String nombre,String descripcion, boolean notificacion
            , int planta){
        Localizacion localizacion = new Localizacion(latitud,longitud,planta);
        Optional<Espacio> espacioResultado = repositorioEspacios.ObtenerEspacioPorLoca(localizacion);
        boolean exterior = true;
        String idespacio = "exterior";
        String edificio = "exterior del campus";
        if(espacioResultado.isPresent()){
            exterior=false;
            idespacio=espacioResultado.get().getId();
            edificio = espacioResultado.get().getEdificio();
        }
        Incidencia nuevaIncidencia =  new Incidencia(descripcion,nombre,false,notificacion,new Date(),localizacion,idespacio,edificio);
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
        return nuevaIncidencia;
    }
}
