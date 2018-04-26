package willie.dominio;

import javax.persistence.Entity;
import java.time.DayOfWeek;
import java.util.HashMap;

public class Horario {
    private HashMap<DayOfWeek,IntervalosDeTiempo> ocupacion;

    public void añadirDia(DayOfWeek dia,IntervalosDeTiempo intervalosDeTiempo){
        ocupacion.put(dia, intervalosDeTiempo);
    }
}
