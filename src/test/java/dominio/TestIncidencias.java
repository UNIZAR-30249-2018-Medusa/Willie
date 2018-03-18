package dominio;

import org.junit.Test;
import willie.dominio.ObjetosValor.Estado;
import willie.dominio.ObjetosValor.Localizacion;
import willie.dominio.entidades.Incidencia;
import willie.dominio.entidades.Trabajador;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestIncidencias {

    @Test
    public void estadosDeIncidenciaPendienteAceptada(){
        Incidencia in = new Incidencia("Test",false,false,
                new Date(),new Localizacion());
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.aceptar();
        assertEquals(new Estado("Aceptada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaPendienteCancelada(){
        Incidencia in = new Incidencia("Test",false,false,
                new Date(),new Localizacion());
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.cancelar();
        assertEquals(new Estado("Cancelada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaAceptadaAsignada(){
        Incidencia in = new Incidencia("Test",false,false,
                new Date(),new Localizacion());
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.aceptar();
        in.asignar(new Trabajador());
        assertEquals(new Estado("Asignada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaAsignadaDesasignada(){
        Incidencia in = new Incidencia("Test",false,false,
                new Date(),new Localizacion());
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.aceptar();
        Trabajador pepe = new Trabajador();
        in.asignar(pepe);
        assertEquals(new Estado("Asignada"),in.getEstado());
        in.desasignar(pepe);
        assertEquals(new Estado("Aceptada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaAsignadaCompletada(){
        Incidencia in = new Incidencia("Test",false,false,
                new Date(),new Localizacion());
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.aceptar();
        in.asignar(new Trabajador());
        in.completar();
        assertEquals(new Estado("Completada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaPendienteCanceladaUsr(){
        Incidencia in = new Incidencia("Test",false,false,
                new Date(),new Localizacion());
        assertEquals(new Estado("Pendiente"),in.getEstado());
        long codigo = in.getCodigoCancelacion();
        in.cancelarUsuario(codigo);
        assertEquals(new Estado("CanceladaUsr"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaAceptadaCanceladaUsr(){
        Incidencia in = new Incidencia("Test",false,false,
                new Date(),new Localizacion());
        assertEquals(new Estado("Pendiente"),in.getEstado());
        long codigo = in.getCodigoCancelacion();
        in.aceptar();
        in.cancelarUsuario(codigo);
        assertEquals(new Estado("CanceladaUsr"),in.getEstado());
    }
}
