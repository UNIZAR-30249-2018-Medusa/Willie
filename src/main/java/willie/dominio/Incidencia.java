package willie.dominio;

import java.util.Date;
import java.util.Random;

public class Incidencia extends Entidad {

    private String descripcion;
    private Boolean exterior;
    private Boolean esNotificacion;
    private Date horaFechaCreada;
    private Date HoraFechaCompletada;
    private Espacio espacio;  //Falta navegabilidad.
    private Localizacion localizacion;
    private Trabajador trabajador;
    private long codigoCancelacion;

    private Estado estado;

    //Crear nueva incidencia
    public Incidencia(String descripcion, Boolean exterior, Boolean esNotificacion,
                      Date horaFecha, Localizacion localizacion, Espacio espacio){
        this.descripcion=descripcion;
        this.exterior=exterior;
        this.esNotificacion=esNotificacion;
        this.horaFechaCreada =horaFecha;
        this.localizacion=localizacion;
        this.estado=new Estado("Pendiente");
        Random rand = new Random();                 //Sujeto a cambio.
        this.codigoCancelacion = this.id.getLeastSignificantBits();

        this.espacio = espacio;
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
        this.HoraFechaCompletada = new Date();
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
