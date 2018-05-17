package willie.aplicacion;

import willie.dominio.Estado;
import willie.dominio.Incidencia;
import willie.dominio.Localizacion;

import java.util.Date;

public class InfoIncidencia {
    private Localizacion localizacion;
    private String nombre;
    private String descripcion;
    private Date fechaCreada;
    private String estado;
    private String idespacio;

    public InfoIncidencia(Localizacion localizacion, String nombre, String descripcion, Date fechaCreada, Estado estado,String idespacio) {
        this.localizacion = localizacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreada = fechaCreada;
        this.estado = estado.toString();
        if(estado.equals("CanceladaUsr")){
            this.estado="Cancelada";
        }
        this.idespacio=idespacio;
    }

    public static InfoIncidencia crearInfoDeIncidencia(Incidencia incidencia){
        return new InfoIncidencia(incidencia.getLocalizacion(),incidencia.getNombreIncidencia(),
                incidencia.getDescripcion(),incidencia.getHoraFechaCreada(),incidencia.getEstado(),incidencia.getIdespacio());
    }


}
