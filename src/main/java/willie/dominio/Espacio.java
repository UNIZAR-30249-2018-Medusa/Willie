package willie.dominio;

import javax.persistence.*;

@Entity
public class Espacio {

    @Id
    private String id;
    @OneToOne
    private Horario horario;
    private String edificio;
    private String nombre;
    @Embedded
    private Localizacion localizacion;
    private int plantaEspacio;


    public Espacio(){}
    public Espacio(String edificio, String tipoDeUso, Localizacion localizacion,int planta){
        this.edificio=edificio;
        this.nombre=tipoDeUso;
        this.localizacion=localizacion;
        this.plantaEspacio=planta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPlantaEspacio() {
        return plantaEspacio;
    }
}
