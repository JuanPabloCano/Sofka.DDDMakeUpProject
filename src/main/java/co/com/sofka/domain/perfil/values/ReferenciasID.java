package co.com.sofka.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;

public class ReferenciasID extends Identity {

    public ReferenciasID(String uuid) {
        super(uuid);
    }

    public ReferenciasID(){}

    public static ReferenciasID of(String uuid){
        return new ReferenciasID(uuid);
    }

}
