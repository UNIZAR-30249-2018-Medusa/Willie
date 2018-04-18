package willie.dominio;

public class Localizacion {
    private float latitud;
    private float longitud;

    public Localizacion(float latitud,float longitud){
        this.latitud=latitud;
        this.longitud=longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }
}
