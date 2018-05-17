package aplicacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import willie.Application;
import willie.Infraestructura.RepositorioAdministrador;
import willie.aplicacion.ControladorAdministrador;
import willie.aplicacion.CuentaAdministrador;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestLoginAdministrador {

    @Autowired
    RepositorioAdministrador repositorioAdministrador;

    @Autowired
    ControladorAdministrador controladorAdministrador;

    CuentaAdministrador nueva;
    String auth = "21232f297a57a5a743894a0e4a801fc3";
    boolean setup=false;
    HttpSession session;
    HttpServletResponse response;

    @Before
    public void setUp(){
         response = new MockHttpServletResponse();
         session = new MockHttpSession();
        if(!setup) {
            nueva = new CuentaAdministrador("test", "testCorrecto");
            repositorioAdministrador.save(nueva);
            setup = true;
        }
    }

    @After
    public void tearDown(){
        repositorioAdministrador.delete(nueva);
    }
    @Test
    public void loginEsCorrecto(){
        String resultado = controladorAdministrador.accesoAdministrador("test","testCorrecto",
                auth,response,session);
        Assert.assertEquals("exito",resultado);

    }

    @Test
    public void loginEsInCorrecto(){
        String resultado = controladorAdministrador.accesoAdministrador("test","testInCorrecto",
                auth,response,session);
        Assert.assertEquals("Fallo en el login",resultado);

    }

    @Test
    public void authEsInCorrecto(){
        String resultado = controladorAdministrador.accesoAdministrador("test","testCorrecto",
                " ",response,session);
        Assert.assertEquals("Fallo en la autenticacion",resultado);

    }
}
