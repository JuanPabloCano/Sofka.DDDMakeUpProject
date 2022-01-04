package co.com.sofka.domain.gestionEducacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class PeriodoEducacionModificado extends DomainEvent {

    private final EducacionesID id;
    private final Periodo periodo;

    public PeriodoEducacionModificado(EducacionesID id, Periodo periodo) {
        super("sofka.gestioneducacion.periodoeducacionmodificado");
        this.id = Objects.requireNonNull(id);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public EducacionesID getId() {
        return id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
