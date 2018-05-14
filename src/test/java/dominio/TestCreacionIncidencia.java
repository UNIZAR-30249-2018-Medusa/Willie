/**package dominio;

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

import static org.junit.Assert.assertEquals;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestCreacionIncidencia {

//    @Configuration
//    static class ContextConfiguration{
//        @Bean
//        public RepositorioEspacios repositorioEspacios(){
//            RepositorioEspacios repositorioEspacios = new RepoEspacioDominio();
//            return repositorioEspacios;
//        }
//    }
    @Autowired
    RepositorioIncidencias repositorioIncidencias;
    
    @Test
    public void creacionIncidencia() {
    	Incidencia in = new Incidencia();
        repositorioIncidencias.save(in);
    }
}*/
