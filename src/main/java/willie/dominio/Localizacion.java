package willie.dominio;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Localizacion {

    private double latitud;
    private double longitud;
    private int planta;

    public Localizacion(double latitud,double longitud,int planta){
        this.latitud=latitud;
        this.longitud=longitud;
        this.planta=planta;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public int getPlanta() {
        return planta;
    }
}
