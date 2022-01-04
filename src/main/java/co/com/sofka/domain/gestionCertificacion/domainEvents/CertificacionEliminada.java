package co.com.sofka.domain.gestionCertificacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;

import java.util.Objects;

public class CertificacionEliminada extends DomainEvent {

    private final CertificacionID certificacionID;

    public CertificacionEliminada(CertificacionID certificacionID) {
        super("sofka.gestioncertificacion.certificacioneliminada");
        this.certificacionID = Objects.requireNonNull(certificacionID);
    }

    public CertificacionID getCertificacionID() {
        return certificacionID;
    }
}
