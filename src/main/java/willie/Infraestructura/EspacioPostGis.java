package willie.Infraestructura;

import willie.dominio.Espacio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EspacioPostGis {

    @Id
    String layer;
    String id_utc;
    String id_centro;
    Double tipo_de_us;
    String id_edificio;

    public EspacioPostGis(){}
    public EspacioPostGis(String layer, String id_utc, String id_centro, Double tipo_de_us, String id_edificio) {
        this.layer = layer;
        this.id_utc = id_utc;
        this.id_centro = id_centro;
        this.tipo_de_us = tipo_de_us;
        this.id_edificio = id_edificio;
    }

    Espacio extraeEspacio(){
        return new Espacio(id_edificio,id_centro,null,Integer.parseInt(id_utc.split(".")[0]));
    }


}

