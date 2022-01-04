package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.Cedula;
import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class CedulaModificada extends DomainEvent {

    private final Cedula cedula;

    public CedulaModificada(Cedula cedula) {
        super("sofka.colaborador.cedulamodificada");
        this.cedula = Objects.requireNonNull(cedula);
    }

    public Cedula getCedula() {
        return cedula;
    }
}
