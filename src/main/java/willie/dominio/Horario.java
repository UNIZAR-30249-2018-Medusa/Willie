package willie.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.util.HashMap;

@Entity
public class Horario {
    @Id
    private String utc_espacio;
    private HashMap<DayOfWeek,IntervalosDeTiempo> ocupacion;

    public Horario(){}
    public void añadirDia(DayOfWeek dia,IntervalosDeTiempo intervalosDeTiempo){
        ocupacion.put(dia, intervalosDeTiempo);
    }
}
