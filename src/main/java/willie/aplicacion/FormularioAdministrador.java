package willie.aplicacion;

public class FormularioAdministrador {
    public String nombreUsuario;
    public String password;
    public String authPassword;

    public FormularioAdministrador(){}

    public FormularioAdministrador(String nombreUsuario, String password, String authPassword) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.authPassword = authPassword;
    }
}
