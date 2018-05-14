package dominio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import willie.Application;
import willie.dominio.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

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
        //assertEquals(in,out);

    }
}
