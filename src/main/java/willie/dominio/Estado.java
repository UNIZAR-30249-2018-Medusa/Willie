package willie.dominio;


import java.util.Date;
import java.util.Objects;

public class Estado {

    /*Posibles nombre de estados:
            Pendiente
            Cancelada
            Aceptada
            Asignada
            Completada
            CanceladaUsr
         */
    private String nombre;
    private Date horaFechaCompletada;

    public Estado(String nombre){
        assert(nombre.equals("Pendiente") ||
                nombre.equals("Cancelada") ||
                nombre.equals("Aceptada") ||
                nombre.equals("Asignada") ||
                nombre.equals("Completada") ||
                nombre.equals("CanceladaUsr"));
        this.nombre=nombre;
    }

    public void finalizar(Date horaFechaCompletada){
        this.horaFechaCompletada=horaFechaCompletada;
    }
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(nombre, estado.nombre);
    }

}
