package co.com.sofka.domain.gestionCertificacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class PeriodoCertificacionModificado extends DomainEvent {

    private final CertificacionID id;
    private final Periodo periodo;

    public PeriodoCertificacionModificado(CertificacionID id, Periodo periodo) {
        super("sofka.gestioncertificacion.periodocertificacionmodificado");
        this.id = Objects.requireNonNull(id);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public CertificacionID getId() {
        return id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
