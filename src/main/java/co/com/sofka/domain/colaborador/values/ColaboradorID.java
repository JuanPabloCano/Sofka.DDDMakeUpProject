package co.com.sofka.domain.colaborador.values;

import co.com.sofka.domain.generic.Identity;

public class ColaboradorID extends Identity {

    public ColaboradorID(String uuid) {
        super(uuid);
    }

    public ColaboradorID(){}

    public static ColaboradorID of(String uuid){
        return new ColaboradorID(uuid);
    }
}
