package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;

import java.util.Objects;

public class InformacionDeContactoActualizada extends DomainEvent {

    private final InformacionDeContacto informacionDeContacto;

    public InformacionDeContactoActualizada(InformacionDeContacto informacionDeContacto) {
        super("sofka.perfil.informaciondecontactoactualizada");
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
