package willie.Infraestructura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface RepoEspacioPostGis extends CrudRepository<EspacioPostGis,String> {

    @Query("SELECT * FROM ada_planta_:planta, betan_planta_:planta, torres_planta_:planta " +
    	   "WHERE ST_Contains(the_geom, ST_Point(:lat, :lon))")
    EspacioPostGis findByCoordinates(@Param("lat") String lat,
    								 @Param("lon") String lon,
    								 @Param("planta") int planta);

}
