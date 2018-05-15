package willie.Infraestructura;

import willie.dominio.Espacio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EspacioPostGis {

    @Id
    private String layer;
    private String id_utc;
    private String id_centro;
    private Double tipo_de_us;
    private String id_edifici;

    public EspacioPostGis(){}
    public EspacioPostGis(String layer, String id_utc, String id_centro, Double tipo_de_us, String id_edifici) {
        this.layer = layer;
        this.id_utc = id_utc;
        this.id_centro = id_centro;
        this.tipo_de_us = tipo_de_us;
        this.id_edifici = id_edifici;

    }

    Espacio extraeEspacio(){
        switch (this.id_edifici){
            case "CRE.1200.":
                this.id_edifici = "Ada Byron";
                break;
            case "CRE.1201.":
                this.id_edifici = "Betancourt";
                break;
            case "CRE.1065.":
                this.id_edifici = "Torres Quevedo";
                break;
        }
        return new Espacio(id_edifici,id_centro,null,Character.getNumericValue(id_utc.charAt(1)));
    }


}

