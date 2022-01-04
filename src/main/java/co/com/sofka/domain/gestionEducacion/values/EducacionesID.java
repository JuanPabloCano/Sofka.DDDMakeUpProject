package co.com.sofka.domain.gestionEducacion.values;

import co.com.sofka.domain.generic.Identity;

public class EducacionesID extends Identity {

    public EducacionesID(String uuid) {
        super(uuid);
    }

    public EducacionesID(){}

    public static EducacionesID of(String uuid){
        return new EducacionesID(uuid);
    }

}
