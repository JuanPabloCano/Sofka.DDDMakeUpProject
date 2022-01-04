package co.com.sofka.domain.gestionEducacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.generics.HojaDeVidaID;

import java.util.Objects;

public class GestionEducacionCreada extends DomainEvent {

    private final GestionEducacionID gestionEducacionID;
    private final HojaDeVidaID hojaDeVidaID;

    public GestionEducacionCreada(GestionEducacionID gestionEducacionID, HojaDeVidaID hojaDeVidaID) {
        super("sofka.gestioneducacion.gestioneducacioncreada");
        this.gestionEducacionID = Objects.requireNonNull(gestionEducacionID);
        this.hojaDeVidaID = Objects.requireNonNull(hojaDeVidaID);
    }

    public GestionEducacionID getGestionEducacionID() {
        return gestionEducacionID;
    }

    public HojaDeVidaID getHojaDeVidaID() {
        return hojaDeVidaID;
    }
}
