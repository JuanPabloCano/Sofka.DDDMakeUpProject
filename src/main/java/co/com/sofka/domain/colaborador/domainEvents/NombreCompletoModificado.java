package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class NombreCompletoModificado extends DomainEvent {

    private final ColaboradorID colaboradorID;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoModificado(ColaboradorID colaboradorID, NombreCompleto nombreCompleto) {
        super("sofka.colaborador.nombrecompletomodificado");
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
