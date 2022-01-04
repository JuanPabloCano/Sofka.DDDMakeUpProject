package co.com.sofka.domain.experiencia.commands;

import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class EliminarExperienciaLaboral extends Command {

    private final ExperienciaID experienciaID;
    private final ExperienciaLaboralID experienciaLaboralID;

    public EliminarExperienciaLaboral(ExperienciaID experienciaID, ExperienciaLaboralID experienciaLaboralID) {
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.experienciaLaboralID = Objects.requireNonNull(experienciaLaboralID);
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public ExperienciaLaboralID getExperienciaLaboralID() {
        return experienciaLaboralID;
    }
}
