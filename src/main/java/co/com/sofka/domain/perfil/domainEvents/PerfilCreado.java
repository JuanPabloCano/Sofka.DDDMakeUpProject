package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.FotoDePerfil;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.HojaDeVidaID;

import java.util.Objects;

public class PerfilCreado extends DomainEvent {

    private final PerfilID perfilID;
    private final HojaDeVidaID hojaDeVidaID;
    private final InformacionDeContacto informacionDeContacto;
    private final FotoDePerfil fotoDePerfil;

    public PerfilCreado(PerfilID perfilID, HojaDeVidaID hojaDeVidaID, InformacionDeContacto informacionDeContacto, FotoDePerfil fotoDePerfil) {
        super("sofka.perfil.perfilcreado");
        this.perfilID = Objects.requireNonNull(perfilID);
        this.hojaDeVidaID = Objects.requireNonNull(hojaDeVidaID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
        this.fotoDePerfil = Objects.requireNonNull(fotoDePerfil);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }

    public HojaDeVidaID getHojaDeVidaID() {
        return hojaDeVidaID;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }
}
