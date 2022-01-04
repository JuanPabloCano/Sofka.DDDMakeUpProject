package co.com.sofka.domain.experiencia.domainEvents;

import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class PeriodoExperienciaLaboralModificada extends DomainEvent {

    private final ExperienciaLaboralID id;
    private final Periodo periodo;

    public PeriodoExperienciaLaboralModificada(ExperienciaLaboralID id, Periodo periodo) {
        super("sofka.experiencia.periodoexperiencialaboralmodificada");
        this.id = Objects.requireNonNull(id);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public ExperienciaLaboralID getId() {
        return id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
