package co.com.sofka.domain.gestionCertificacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.generics.HojaDeVidaID;

import java.util.Objects;

public class GestionCertificacionCreada extends DomainEvent {

    private final GestionCertificacionID gestionCertificacionID;
    private final HojaDeVidaID hojaDeVidaID;

    public GestionCertificacionCreada(GestionCertificacionID gestionCertificacionID, HojaDeVidaID hojaDeVidaID) {
        super("sofka.gestioncertificacion.gestioncertificacioncreada");
        this.gestionCertificacionID = Objects.requireNonNull(gestionCertificacionID);
        this.hojaDeVidaID = Objects.requireNonNull(hojaDeVidaID);
    }

    public GestionCertificacionID getGestionCertificacionID() {
        return gestionCertificacionID;
    }

    public HojaDeVidaID getHojaDeVidaID() {
        return hojaDeVidaID;
    }
}
