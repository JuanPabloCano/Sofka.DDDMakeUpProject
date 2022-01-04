package co.com.sofka.domain.experiencia.domainEvents;

import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class ExperienciaLaboralEliminada extends DomainEvent {

    private final ExperienciaLaboralID experienciaLaboralID;

    public ExperienciaLaboralEliminada(ExperienciaLaboralID experienciaLaboralID) {
        super("sofka.experiencia.experiencialaboraleliminada");
        this.experienciaLaboralID = Objects.requireNonNull(experienciaLaboralID);
    }

    public ExperienciaLaboralID getExperienciaLaboralID() {
        return experienciaLaboralID;
    }
}
