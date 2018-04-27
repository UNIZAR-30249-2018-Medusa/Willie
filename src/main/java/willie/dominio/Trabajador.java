package willie.dominio;

public class Trabajador {
    private String nombreTrabajador;
    private String username;
    private String password;

    public String getNombre() {
        return nombreTrabajador;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Trabajador(){}
    public Trabajador(String nombre, String username, String password) {
        this.nombreTrabajador = nombre;
        this.username = username;
        this.password = password;
    }
}
