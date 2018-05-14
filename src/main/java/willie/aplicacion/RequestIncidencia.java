package willie.aplicacion;

public class RequestIncidencia {
    private String descripcion;
    private String nombre;
    private float latitud;
    private float longitud;
    private boolean notificacion;
    private int planta;

    public RequestIncidencia(){}
    public RequestIncidencia(String descripcion,String nombre, float latitud, float longitud, boolean notificacion, int planta) {
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

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
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
