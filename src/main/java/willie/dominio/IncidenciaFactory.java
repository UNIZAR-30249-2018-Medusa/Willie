package willie.dominio;

import java.util.Date;

public class IncidenciaFactory {

    public static Incidencia crearIncidencia(float latitud, float longitud, String descripcion, boolean notificacion){
        Localizacion localizacion = new Localizacion(latitud,longitud);
        Espacio espacio = null; //TODO: Obtener un espacion dadas unas coordenadas a través de un servicio de dominio
        return new Incidencia(descripcion,false,notificacion,new Date(),localizacion,espacio);
    }
}
