package willie.Infraestructura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEspacioPostGis extends CrudRepository<EspacioPostGis,String> {

    @Query(value = "SELECT * FROM ada_planta_0 a WHERE ST_Contains(a.the_geom, ST_SetSRID(ST_Point(?1,?2),25830))\n" +
            "UNION\n" +
            "SELECT * FROM betan_planta_0 b WHERE ST_Contains(b.the_geom, ST_SetSRID(ST_Point(?1,?2),25830))\n" +
            "UNION\n" +
            "SELECT * FROM torres_planta_0 t WHERE ST_Contains(t.the_geom, ST_SetSRID(ST_Point(?1,?2),25830))",
            nativeQuery = true)
    EspacioPostGis findByCoordinates( Double lon,
    								 Double lat);

}

