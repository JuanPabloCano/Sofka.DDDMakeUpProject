package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.ReferenciasID;

import java.util.Objects;

public class InformacionDeContactoReferenciaActualizado extends DomainEvent {

    private final ReferenciasID referenciasID;
    private final InformacionDeContacto informacionDeContacto;

    public InformacionDeContactoReferenciaActualizado(ReferenciasID referenciasID,
                                                      InformacionDeContacto informacionDeContacto) {
        super("sofka.perfil.informaciondecontactoactualizado");
        this.referenciasID = Objects.requireNonNull(referenciasID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public ReferenciasID getReferenciasID() {
        return referenciasID;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
