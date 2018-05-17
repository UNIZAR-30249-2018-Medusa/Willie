package willie.aplicacion;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class CuentaAdministrador {

    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=2, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    private int id;

    private String usuario;
    private String pass;

    public CuentaAdministrador(){}
    public CuentaAdministrador(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }
    public CuentaAdministrador(FormularioAdministrador cuenta){
        this.usuario=cuenta.nombreUsuario;
        this.pass=cuenta.password;
    }

    public boolean loginCorrecto(String pass){
        return this.pass.equals(pass);
    }

    @Override
    public String toString() {
        return "CuentaAdministrador{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
