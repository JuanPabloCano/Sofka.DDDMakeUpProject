package co.com.sofka.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;

public class ExperienciaLaboralID extends Identity {

    public ExperienciaLaboralID(String uuid) {
        super(uuid);
    }

    public ExperienciaLaboralID(){}

    public static ExperienciaLaboralID of(String uuid){
        return new ExperienciaLaboralID(uuid);
    }

}
