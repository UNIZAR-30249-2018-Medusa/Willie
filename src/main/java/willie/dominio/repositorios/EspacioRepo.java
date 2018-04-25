package willie.dominio.repositorios;

import org.springframework.data.repository.CrudRepository;

import willie.dominio.entidades.Espacio;

public interface EspacioRepo extends CrudRepository<Espacio, String> {
	
	@Query(/*SELECT _ FROM _ WHERE ST_Contains(the _geom, ST_Point(loc.x, loc.y))*/)
	Espacio findEspacio(Localizacion loc);

}
