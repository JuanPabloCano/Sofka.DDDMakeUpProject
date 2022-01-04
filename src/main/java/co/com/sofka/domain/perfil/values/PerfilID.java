package co.com.sofka.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;

public class PerfilID extends Identity {

    public PerfilID(String uuid) {
        super(uuid);
    }

    public PerfilID(){}

    public static PerfilID of(String uuid){
        return new PerfilID(uuid);
    }

}
