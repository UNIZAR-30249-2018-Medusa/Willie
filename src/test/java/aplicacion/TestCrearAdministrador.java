package aplicacion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
import willie.aplicacion.FormularioAdministrador;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestCrearAdministrador {

    @Autowired
    RepositorioAdministrador repositorioAdministrador;

    @Autowired
    ControladorAdministrador controladorAdministrador;

    CuentaAdministrador nueva;
    String auth = "21232f297a57a5a743894a0e4a801fc3";
    HttpSession session;
    HttpServletResponse response;

    @Before
    public void setUp(){
         response = new MockHttpServletResponse();
         session = new MockHttpSession();
    }

    @After
    public void tearDown(){
        repositorioAdministrador.deleteByUsuario("test1");
    }

    @Test
    public void loginCorrectoTrasInsercion(){
        controladorAdministrador.registroAdministrador(new FormularioAdministrador("test1","testCorrecto",auth)
                ,response,session);
        String resultado = controladorAdministrador.accesoAdministrador("test1","testCorrecto",
                auth,response,session);
        Assert.assertEquals("exito",resultado);

    }

}
