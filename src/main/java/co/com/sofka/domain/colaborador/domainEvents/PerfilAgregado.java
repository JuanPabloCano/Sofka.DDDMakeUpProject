package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.PerfilID;

import java.util.Objects;

public class PerfilAgregado extends DomainEvent {

    private final PerfilID perfilID;

    public PerfilAgregado(PerfilID perfilID) {
        super("sofka.colaborador.perfilagregado");
        this.perfilID = Objects.requireNonNull(perfilID);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }
}
