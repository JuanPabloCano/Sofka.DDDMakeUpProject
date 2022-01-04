package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class NuevaReferenciaAgregada extends DomainEvent {

    private final ReferenciasID referenciasID;
    private final InformacionDeContacto informacionDeContacto;
    private final NombreCompleto nombreCompleto;

    public NuevaReferenciaAgregada(ReferenciasID referenciasID, InformacionDeContacto informacionDeContacto, NombreCompleto nombreCompleto) {
        super("sofka.perfil.nuevareferenciaagregada");
        this.referenciasID = Objects.requireNonNull(referenciasID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public ReferenciasID getReferenciasID() {
        return referenciasID;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
