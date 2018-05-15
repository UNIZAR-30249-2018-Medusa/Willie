package dominio;

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
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestCreacionIncidencia {

    @Autowired
    RepositorioIncidencias repositorioIncidencias;
    
    @Test
    public void creacionIncidencia() {
    	Incidencia in = new Incidencia("incidencia de prueba","test",false,false,new Date(),
                new Localizacion(4616791.0,675734.3,0),"pasillo");
        UUID nueva = in.getId();
        repositorioIncidencias.anyadirIncidencia(in);
        Incidencia out = repositorioIncidencias.buscarIncidenciaId(nueva);
        assertThat (in.equals(out));
    }
}
