package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class NombreCompletoReferenciaActualizado extends DomainEvent {

    private final ReferenciasID referenciasID;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoReferenciaActualizado(ReferenciasID referenciasID, NombreCompleto nombreCompleto) {
        super("sofka.perfil.nombrecompletoreferenciaactualizado");
        this.referenciasID = Objects.requireNonNull(referenciasID);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public ReferenciasID getReferenciasID() {
        return referenciasID;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
