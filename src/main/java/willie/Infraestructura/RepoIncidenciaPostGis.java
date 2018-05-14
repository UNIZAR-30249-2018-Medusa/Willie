

package willie.Infraestructura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RepoIncidenciaPostGis extends CrudRepository<EspacioPostGis,String> {

    @Query(value = "INSERT INTO incidencias VALUES (?1,?2,?3,?4,?5,?6,?7,?8);",
            nativeQuery = true)
    Void save(Long codigocancelacion,
              String Descripcion, Boolean exterior, String estado,
              Date fecha, String nombre_trabajador, Long codigo,
              String nombre_incidencia);







}

