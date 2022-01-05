package co.com.sofka.domain.gestionCertificacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;

import java.util.Objects;

public class NombreCertificacionModificada extends DomainEvent {

    private final CertificacionID id;
    private final Nombre nombre;

    public NombreCertificacionModificada(CertificacionID id, Nombre nombre) {
        super("sofka.gestioncertificacion.nombrecertificacionmodificada");
        this.id = Objects.requireNonNull(id);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public CertificacionID getId() {
        return id;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
