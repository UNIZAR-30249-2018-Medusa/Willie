package dominio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import willie.Application;
import willie.dominio.*;

import static org.junit.Assert.assertEquals;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestBusquedaEspacio {
    @Autowired
    RepositorioEspacios repositorioEspacios;
    @Test
    public void BusquedaPasillo(){
        Localizacion loc = new Localizacion(4616791.0,675734.3,0);
        Optional<Espacio> espacio = repositorioEspacios.ObtenerEspacioPorLoca(loc);
        assertEquals("PASILLO",espacio.get().getNombre());
        assertEquals(0,espacio.get().getPlantaEspacio());
        assertEquals("Ada Byron",espacio.get().getEdificio());
    }
}
