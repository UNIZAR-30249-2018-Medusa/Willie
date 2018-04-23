package willie.dominio.entidades;

public class Espacio {
    private String nombre;
    private int planta;
    private String edificio;
    private int horarios;

    public String getNombre() {
        return nombre;
    }

    public int getPlanta() {
        return planta;
    }

    public String getEdificio() {
        return edificio;
    }

    public int getHorarios() {
        return horarios;
    }

    public Espacio(String nombre, int planta, String edificio, int horarios) {
        this.nombre = nombre;
        this.planta = planta;
        this.edificio = edificio;
        this.horarios = horarios;
    }

}
