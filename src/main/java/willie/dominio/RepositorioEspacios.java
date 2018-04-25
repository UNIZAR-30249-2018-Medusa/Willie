package willie.dominio;


import java.util.Optional;

public interface RepositorioEspacios {

    Optional<Espacio> ObtenerEspacioPorLoca(Localizacion localizacion);

}
