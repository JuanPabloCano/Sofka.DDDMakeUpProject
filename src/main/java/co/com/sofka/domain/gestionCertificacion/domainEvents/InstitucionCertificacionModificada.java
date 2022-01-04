package co.com.sofka.domain.gestionCertificacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.generics.Institucion;

import java.util.Objects;

public class InstitucionCertificacionModificada extends DomainEvent {

    private final CertificacionID id;
    private final Institucion institucion;

    public InstitucionCertificacionModificada(CertificacionID id, Institucion institucion) {
        super("sofka.gestioncertificacion.institucioncertificacionmodificada");
        this.id = Objects.requireNonNull(id);
        this.institucion = Objects.requireNonNull(institucion);
    }

    public CertificacionID getId() {
        return id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
