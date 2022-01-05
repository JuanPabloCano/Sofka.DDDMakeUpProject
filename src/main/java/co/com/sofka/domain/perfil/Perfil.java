package co.com.sofka.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.domainEvents.*;
import co.com.sofka.domain.perfil.values.FotoDePerfil;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.NombreCompleto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Perfil extends AggregateEvent<PerfilID> {

    protected HojaDeVidaID hojaDeVidaID;
    protected InformacionDeContacto informacionDeContacto;
    protected FotoDePerfil fotoDePerfil;
    protected Referencias referencias;

    private Perfil(PerfilID perfilID) {
        super(perfilID);
        subscribe(new PerfilChange(this));
    }

    public Perfil(PerfilID perfilID, HojaDeVidaID hojaDeVidaID, InformacionDeContacto informacionDeContacto,
                  FotoDePerfil fotoDePerfil) {
        super(perfilID);
        appendChange(new PerfilCreado(perfilID, hojaDeVidaID, informacionDeContacto, fotoDePerfil)).apply();
    }

    public static Perfil from(PerfilID perfilID, List<DomainEvent> events) {
        var perfil = new Perfil(perfilID);
        events.forEach(perfil::applyEvent);
        return perfil;
    }

    public void agregarNuevaReferencia(InformacionDeContacto informacionDeContacto,
                                       NombreCompleto nombreCompleto) {
        var id = new ReferenciasID();
        Objects.requireNonNull(informacionDeContacto);
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NuevaReferenciaAgregada(id, informacionDeContacto, nombreCompleto)).apply();
    }

    public void actualizarInformacionDeContacto(InformacionDeContacto informacionDeContacto) {
        Objects.requireNonNull(informacionDeContacto);
        appendChange(new InformacionDeContactoActualizada(informacionDeContacto)).apply();
    }

    public void actualizarFotoDePerfil(FotoDePerfil fotoDePerfil) {
        Objects.requireNonNull(informacionDeContacto);
        appendChange(new FotoDePerfilActualizada(fotoDePerfil)).apply();
    }

    public void actualizarNombreCompletoReferencia(NombreCompleto nombreCompleto){
        var id = new ReferenciasID();
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoReferenciaActualizado(id, nombreCompleto)).apply();
    }

    public void actualizarInformacionDeContactoReferencia(InformacionDeContacto informacionDeContacto){
        var id = new ReferenciasID();
        Objects.requireNonNull(informacionDeContacto);
        appendChange(new InformacionDeContactoReferenciaActualizado(id, informacionDeContacto)).apply();
    }

    public HojaDeVidaID HojaDeVidaID() {
        return hojaDeVidaID;
    }

    public InformacionDeContacto InformacionDeContacto() {
        return informacionDeContacto;
    }

    public FotoDePerfil FotoDePerfil() {
        return fotoDePerfil;
    }

    public Referencias Referencias() {
        return referencias;
    }
}
