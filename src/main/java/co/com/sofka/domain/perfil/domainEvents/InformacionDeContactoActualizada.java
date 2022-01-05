package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;

import java.util.Objects;

public class InformacionDeContactoActualizada extends DomainEvent {

    private final PerfilID perfilID;
    private final InformacionDeContacto informacionDeContacto;

    public InformacionDeContactoActualizada(PerfilID perfilID, InformacionDeContacto informacionDeContacto) {
        super("sofka.perfil.informaciondecontactoactualizada");
        this.perfilID = Objects.requireNonNull(perfilID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
