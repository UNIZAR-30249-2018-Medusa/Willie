package willie.dominio;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class IncidenciaFactory {

    @Autowired
    RepositorioEspacios repositorioEspacios;

    public Incidencia crearIncidencia(Double latitud,Double longitud, String nombre,String descripcion, boolean notificacion
            , String idespacio){

        Incidencia in = new Incidencia(descripcion,nombre,false,false,new Date(),
                new Localizacion(4616791.0,675734.3,0),"AULA_A.01");
        return in;
    }
}

    /**Localizacion localizacion = new Localizacion(latitud,longitud,planta);
    //TODO: Obtener un espacion dadas unas coordenadas a través de un servicio de dominio
    Optional<Espacio> espacioResultado = repositorioEspacios.ObtenerEspacioPorLoca(localizacion);
    boolean exterior = true;
    String idespacio = "exterior";
        if(espacioResultado.isPresent()){
                exterior=false;
                idespacio=espacioResultado.get().getId();
                System.out.println(idespacio +" EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                }*/