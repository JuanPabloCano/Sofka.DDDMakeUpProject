package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class NombreCompletoModificado extends DomainEvent {

    private final NombreCompleto nombreCompleto;

    public NombreCompletoModificado(NombreCompleto nombreCompleto) {
        super("sofka.colaborador.nombrecompletomodificado");
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
