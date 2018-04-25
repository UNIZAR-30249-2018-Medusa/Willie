package willie.Infraestructura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEspacioPostGis extends CrudRepository<EspacioPostGis,String> {

    @Query("") //Aqui va la query de postgis
    EspacioPostGis findByCoordinates(String lat,String lon);

}
