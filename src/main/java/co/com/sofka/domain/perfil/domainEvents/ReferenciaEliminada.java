package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.ReferenciasID;

import java.util.Objects;

public class ReferenciaEliminada extends DomainEvent {

    private final ReferenciasID referenciasID;

    public ReferenciaEliminada(ReferenciasID referenciasID) {
        super("sofka.perfil.referenciaeliminada");
        this.referenciasID = Objects.requireNonNull(referenciasID);
    }

    public ReferenciasID getReferenciasID() {
        return referenciasID;
    }
}
