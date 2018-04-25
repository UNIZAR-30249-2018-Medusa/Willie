package willie.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Espacio {

    @Id
    private String id;
    private Horario horario;
    private String edificio;
    private String nombre;
    private Localizacion localizacion;
    private int planta;


    public Espacio(String edificio, String tipoDeUso, Localizacion localizacion,int planta){
        this.edificio=edificio;
        this.nombre=tipoDeUso;
        this.localizacion=localizacion;
        this.planta=planta;
    }

    public String getId() {
        return id;
    }
}
