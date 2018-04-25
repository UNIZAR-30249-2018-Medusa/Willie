package willie.dominio;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class IncidenciaFactory {

    @Autowired
    RepositorioEspacios repositorioEspacios;

    public Incidencia crearIncidencia(float latitud, float longitud, String descripcion, boolean notificacion
            , int planta){
        Localizacion localizacion = new Localizacion(latitud,longitud,planta);
        //TODO: Obtener un espacion dadas unas coordenadas a través de un servicio de dominio
        Optional<Espacio> espacioResultado = repositorioEspacios.ObtenerEspacioPorLoca(localizacion);
        boolean exterior = true;
        String idespacio = "exterior";
        if(espacioResultado.isPresent()){
            exterior=false;
            idespacio=espacioResultado.get().getId();
        }
        return new Incidencia(descripcion,false,notificacion,new Date(),localizacion,idespacio);
    }
}
