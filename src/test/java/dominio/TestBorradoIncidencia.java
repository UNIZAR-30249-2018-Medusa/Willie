package dominio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import willie.Application;
import willie.dominio.Incidencia;
import willie.dominio.IncidenciaFactory;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioIncidencias;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestBorradoIncidencia {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;

    @Autowired
    IncidenciaFactory incidenciaFactory;
    Incidencia in;

    Logger log = LoggerFactory.getLogger(TestObtenerRegistroIncidencias.class);

    @Before
    public void instertarIncidenciaDePrueba(){
        in = incidenciaFactory.crearIncidencia(4616791.0,675734.3,
                "testBorrado","incidencia de prueba",false,0);
        repositorioIncidencias.anyadirIncidencia(in);
    }

    @Test
    public void seBorraUnaIncidencia() {
        ArrayList<Incidencia> antes = repositorioIncidencias.IncidenciasPorFecha();
        log.info(String.valueOf(antes.size()));
        repositorioIncidencias.borrarIncidencia(in);
        ArrayList<Incidencia> despues = repositorioIncidencias.IncidenciasPorFecha();
        assertThat (antes.size() > despues.size()).isTrue();
    }
}