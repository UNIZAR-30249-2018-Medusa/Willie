package willie.dominio;

import javax.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class Entidad {
	
    @Id
    protected String id;

    public Entidad(){
        id = UUID.randomUUID().toString();
    }

}
