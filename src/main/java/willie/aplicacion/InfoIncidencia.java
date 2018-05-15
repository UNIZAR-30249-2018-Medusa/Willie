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
    private Estado estado;

    public InfoIncidencia(Localizacion localizacion, String nombre, String descripcion, Date fechaCreada, Estado estado) {
        this.localizacion = localizacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreada = fechaCreada;
        this.estado = estado;
    }

    public static InfoIncidencia crearInfoDeIncidencia(Incidencia incidencia){
        return new InfoIncidencia(incidencia.getLocalizacion(),incidencia.getNombreIncidencia(),
                incidencia.getDescripcion(),incidencia.getHoraFechaCreada(),incidencia.getEstado());
    }
}
