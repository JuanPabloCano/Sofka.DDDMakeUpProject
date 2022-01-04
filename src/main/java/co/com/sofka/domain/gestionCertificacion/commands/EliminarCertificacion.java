package co.com.sofka.domain.gestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;

import java.util.Objects;

public class EliminarCertificacion extends Command {

    private final GestionCertificacionID gestionCertificacionID;
    private final CertificacionID certificacionID;

    public EliminarCertificacion(GestionCertificacionID gestionCertificacionID, CertificacionID certificacionID) {
        this.gestionCertificacionID = Objects.requireNonNull(gestionCertificacionID);
        this.certificacionID = Objects.requireNonNull(certificacionID);
    }

    public GestionCertificacionID getGestionCertificacionID() {
        return gestionCertificacionID;
    }

    public CertificacionID getCertificacionID() {
        return certificacionID;
    }
}
