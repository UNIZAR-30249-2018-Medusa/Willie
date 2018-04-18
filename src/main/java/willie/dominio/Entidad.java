package willie.dominio;


import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Entidad {
    @Id
    protected UUID id = UUID.randomUUID();

}
