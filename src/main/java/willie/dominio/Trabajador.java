package willie.dominio;

public class Trabajador {
    private String nombre;
    private String username;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Trabajador(String nombre, String username, String password) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }
}
