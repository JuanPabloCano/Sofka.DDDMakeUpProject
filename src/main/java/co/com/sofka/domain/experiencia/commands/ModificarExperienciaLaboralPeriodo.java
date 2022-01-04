package co.com.sofka.domain.experiencia.commands;

import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class ModificarExperienciaLaboralPeriodo extends Command {

    private final ExperienciaID experienciaID;
    private final Periodo periodo;

    public ModificarExperienciaLaboralPeriodo(ExperienciaID experienciaID, Periodo periodo) {
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
