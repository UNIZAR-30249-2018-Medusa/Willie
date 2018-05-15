package dominio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import willie.Application;
import willie.dominio.Incidencia;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioIncidencias;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestObtenerRegistroIncidencias {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;

    Incidencia in;
    Incidencia inVieja;
    Incidencia inModerna;

    Logger log = LoggerFactory.getLogger(TestObtenerRegistroIncidencias.class);

    @Before
    public void crearIncidencias(){
        in = new Incidencia("incidencia de prueba","test",false,false,new Date(),
                new Localizacion(4616791.0,675734.3,0),"pasillo");
        Date fechaAntigua = new GregorianCalendar(1995, 02, 10).getTime();
        Date fechaModerna = new GregorianCalendar(2099, 02, 10).getTime();
        inVieja = new Incidencia("incidencia muy antigua","testCrono1",false,
                false,fechaAntigua,
                new Localizacion(4616791.0,675734.3,0),"pasillo");
        inModerna = new Incidencia("incidencia muy nueva","testCrono2",false,
                false,fechaModerna,
                new Localizacion(4616791.0,675734.3,0),"pasillo");
    }
    @Test
    public void RegistroAumentaAlCrearIncidencia(){
        ArrayList<Incidencia> antes = repositorioIncidencias.IncidenciasPorFecha();
        repositorioIncidencias.anyadirIncidencia(in);
        ArrayList<Incidencia> despues = repositorioIncidencias.IncidenciasPorFecha();
        Assert.assertTrue(antes.size()<despues.size());
    }

    @Test
    public void RegistroEstaOrdenadoCronologicamente(){

        repositorioIncidencias.anyadirIncidencia(inVieja);
        repositorioIncidencias.anyadirIncidencia(inModerna);
        ArrayList<Incidencia> despues = repositorioIncidencias.IncidenciasPorFecha();
        log.info(String.valueOf(despues.indexOf(inModerna)));
        log.info(String.valueOf(despues.indexOf(inVieja)));
        log.info(String.valueOf(despues.get(0).getNombreIncidencia()));
        Assert.assertTrue(despues.get(0).getHoraFechaCreada()
                .after(despues.get(despues.size()-1).getHoraFechaCreada()));
    }

    @After
    public void borrarIncidencaisDePrueba(){
        repositorioIncidencias.borrarIncidencia(in);
        repositorioIncidencias.borrarIncidencia(inVieja);
        repositorioIncidencias.borrarIncidencia(inModerna);
    }

}
