package willie.dominio;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;

import java.util.UUID;

@MappedSuperclass
public class Entidad {
	
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    protected UUID id;

    public Entidad(){
        id = UUID.randomUUID();
    }

}
