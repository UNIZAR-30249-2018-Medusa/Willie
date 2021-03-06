package dominio;

import org.junit.Before;
import org.junit.Test;
import willie.dominio.*;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestTransicionEstadosIncidencia {
    Incidencia in;

    @Before
    public void setUp(){
        in = new Incidencia("Test","nombre",false,false,
                new Date(),new Localizacion(new Float(40.5),new Float(0.1),0),new Espacio().getId(),"test");
    }
    @Test
    public void estadosDeIncidenciaPendienteAceptada(){
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.aceptar();
        assertEquals(new Estado("Aceptada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaPendienteCancelada(){
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.cancelar();
        assertEquals(new Estado("Cancelada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaAceptadaAsignada(){
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.aceptar();
        in.asignar(new Trabajador());
        assertEquals(new Estado("Asignada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaAsignadaDesasignada(){
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
        assertEquals(new Estado("Pendiente"),in.getEstado());
        in.aceptar();
        in.asignar(new Trabajador());
        in.completar();
        assertEquals(new Estado("Completada"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaPendienteCanceladaUsr(){
        assertEquals(new Estado("Pendiente"),in.getEstado());
        long codigo = in.getCodigoCancelacion();
        in.cancelarUsuario(codigo);
        assertEquals(new Estado("CanceladaUsr"),in.getEstado());
    }

    @Test
    public void estadosDeIncidenciaAceptadaCanceladaUsr(){
        assertEquals(new Estado("Pendiente"),in.getEstado());
        long codigo = in.getCodigoCancelacion();
        in.aceptar();
        in.cancelarUsuario(codigo);
        assertEquals(new Estado("CanceladaUsr"),in.getEstado());
    }
}
