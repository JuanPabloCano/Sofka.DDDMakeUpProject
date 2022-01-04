package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.Cedula;
import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class CedulaModificada extends DomainEvent {

    private final ColaboradorID colaboradorID;
    private final Cedula cedula;

    public CedulaModificada(ColaboradorID colaboradorID, Cedula cedula) {
        super("sofka.colaborador.cedulamodificada");
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.cedula = Objects.requireNonNull(cedula);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public Cedula getCedula() {
        return cedula;
    }
}
