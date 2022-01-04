package co.com.sofka.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;

public class ExperienciaID extends Identity {

    public ExperienciaID(String uuid) {
        super(uuid);
    }

    public ExperienciaID(){}

    public static ExperienciaID of(String uuid){
        return new ExperienciaID(uuid);
    }
}
