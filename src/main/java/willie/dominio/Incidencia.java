package willie.dominio;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name="incidencia")
public class Incidencia extends Entidad {

    private String descripcion;
    private String nombre;
    private Boolean exterior;
    private Boolean esNotificacion;
    private Date horaFechaCreada;
    private String idespacio;
    @Embedded
    private Localizacion localizacion;
    @Embedded
    private Trabajador trabajador;
    private long codigoCancelacion;

    @Embedded
    private Estado estado;

    public Incidencia(){}
    //Crear nueva incidencia
    public Incidencia(String descripcion, String nombre, Boolean exterior, Boolean esNotificacion,
                      Date horaFecha, Localizacion localizacion, String idespacio){
        this.descripcion=descripcion;
        this.nombre = nombre;
        this.exterior=exterior;
        this.esNotificacion=esNotificacion;
        this.horaFechaCreada =horaFecha;
        this.localizacion=localizacion;
        this.estado=new Estado("Pendiente");
        Random rand = new Random();                 //Sujeto a cambio.
        this.codigoCancelacion = this.id.getLeastSignificantBits();

        this.idespacio = idespacio;
    }
    public void aceptar() {
        //Estado a aceptado.
        assert(this.estado.equals(new Estado("Pendiente")));
        this.estado = new Estado("Aceptada");
    }

    public void cancelar() {
        assert(this.estado.equals(new Estado("Pendiente")));
        this.estado = new Estado("Cancelada");
    }

    public void asignar(Trabajador trabajador){
        assert(this.estado.equals(new Estado("Aceptada")));
        //Compatibilidad trabajador y horario espacio??
        this.trabajador = trabajador;
        this.estado =  new Estado("Asignada");
    }

    public void desasignar(Trabajador trabajador){
        assert(this.estado.equals(new Estado("Asignada")));
        assert(this.trabajador.equals(trabajador));
        this.trabajador = null;
        this.estado = new Estado("Aceptada");
    }

    public void completar(){
        assert(this.estado.equals(new Estado("Asignada")));
        this.estado = new Estado("Completada");
        this.estado.finalizar(new Date());
    }

    //Devuelve true si el código es correcto, fasle en caso contrario.
    public boolean cancelarUsuario(long codigo){
        assert(this.estado.equals(new Estado("Pendiente")) ||
                this.estado.equals(new Estado("Aceptada")));
        if(this.codigoCancelacion == codigo){
            this.estado =  new Estado("CanceladaUsr");
            return true;
        }else{
            return false;
        }
    }

    public boolean esNotificacion(){
        return esNotificacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public long getCodigoCancelacion() {
        return codigoCancelacion;
    }
}
