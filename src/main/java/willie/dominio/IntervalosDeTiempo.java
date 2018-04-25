package willie.dominio;

import java.util.ArrayList;
import java.util.Date;

public class IntervalosDeTiempo {
    private ArrayList<Date> inicio;
    private ArrayList<Date> fin;

    public IntervalosDeTiempo(Date inicio, Date fin){
        this.inicio.add(inicio);
        this.fin.add(fin);
    }
}
