package dominio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import willie.Application;
import willie.dominio.Incidencia;
import willie.dominio.IncidenciaFactory;
import willie.dominio.Localizacion;
import willie.dominio.RepositorioIncidencias;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestCreacionIncidencia {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;

    @Autowired
    IncidenciaFactory incidenciaFactory;

    Incidencia in;

    @Before
    public void instertarIncidenciaDePrueba(){
        in = incidenciaFactory.crearIncidencia(4616791.0,675734.3,
                "testCreacion","incidencia de prueba",false,0);
        repositorioIncidencias.anyadirIncidencia(in);
    }

    @Test
    public void creacionIncidencia() {
        String nueva = in.getId();
        repositorioIncidencias.anyadirIncidencia(in);
        Incidencia out = repositorioIncidencias.buscarIncidenciaId(nueva);
        assertThat (in.equals(out));
    }

    @After
    public void borrarIncidenciaPrueba(){
        repositorioIncidencias.borrarIncidencia(in);
    }
}
