package willie.dominio;

public class Localizacion {
    private float latitud;
    private float longitud;
    private int planta;

    public Localizacion(float latitud,float longitud,int planta){
        this.latitud=latitud;
        this.longitud=longitud;
        this.planta=planta;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }
}
