package willie.aplicacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import willie.Infraestructura.RepositorioAdministrador;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class ControladorAdministrador {

    @Autowired
    RepositorioAdministrador repositorioAdministrador;

    Logger log = LoggerFactory.getLogger(ControladorAdministrador.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String accesoAdministrador(@RequestParam String nombreUsuario, @RequestParam String password,
                                      @RequestParam String authPassword, HttpServletResponse response,
                                      HttpSession session){

        CuentaAdministrador auth = repositorioAdministrador.findById(0).get();
        log.info(auth.toString());
        if(auth.loginCorrecto(authPassword)){
            Optional<CuentaAdministrador> administrador = repositorioAdministrador.findByUsuario(nombreUsuario);
            if(administrador.isPresent() && administrador.get().loginCorrecto(password)){
                session.setAttribute("ADMIN",administrador.get());
                return "exito";
            }else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return "Fallo en el login";
            }
        }else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "Fallo en la autenticacion";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registroAdministrador(@RequestBody FormularioAdministrador nuevo, HttpServletResponse response,
                                        HttpSession session){

        String authPassword = nuevo.authPassword;
        CuentaAdministrador auth = repositorioAdministrador.findById(0).get();
        log.info(auth.toString());
        if(auth.loginCorrecto(authPassword)){
            Optional<CuentaAdministrador> administrador = repositorioAdministrador.findByUsuario(nuevo.nombreUsuario);
            if(! administrador.isPresent()){
                CuentaAdministrador nuevacuenta = new CuentaAdministrador(nuevo);
                repositorioAdministrador.save(nuevacuenta);
                session.setAttribute("ADMIN",nuevacuenta);
                return "Exito";
            }else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return "Nombre de usuario en uso";
            }
        }else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "Fallo en la autenticacion";
        }
    }
}
