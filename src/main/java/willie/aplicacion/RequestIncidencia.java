package willie.aplicacion;

public class RequestIncidencia {
    private String descripcion;
    private String nombre;
    private Double latitud;
    private Double longitud;
    private boolean notificacion;
    private int planta;

    public RequestIncidencia(){}
    public RequestIncidencia(String descripcion,String nombre, Double latitud, Double longitud, boolean notificacion, int planta) {
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.notificacion = notificacion;
        this.planta = planta;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public boolean isNotificacion() {
        return notificacion;
    }

    public int getPlanta() {
        return planta;
    }

    public String getNombre() {
        return nombre;
    }

}
