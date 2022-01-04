package co.com.sofka.domain.experiencia.commands;

import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Institucion;

import java.util.Objects;

public class ModificarExperienciaLaboralEntidad extends Command {

    private final ExperienciaID experienciaID;
    private final Institucion institucion;

    public ModificarExperienciaLaboralEntidad(ExperienciaID experienciaID, Institucion institucion) {
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.institucion = Objects.requireNonNull(institucion);
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
