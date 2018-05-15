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
import willie.dominio.Localizacion;
import willie.dominio.RepositorioIncidencias;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestCreacionIncidencia {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;

    Incidencia in;

    @Before
    public void instertarIncidenciaDePrueba(){
        in = new Incidencia("incidencia de prueba","testBorrado",false,false,new Date(),
                new Localizacion(4616791.0,675734.3,0),"pasillo");
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
