package co.com.sofka.domain.gestionCertificacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class NuevaCertificacionAgregada extends DomainEvent {

    private final CertificacionID certificacionID;
    private final Nombre nombre;
    private final Institucion institucion;
    private final Periodo periodo;

    public NuevaCertificacionAgregada(CertificacionID certificacionID, Nombre nombre, Institucion institucion, Periodo periodo) {
        super("sofka.gestioncertificacion.nuevacertificacionagregada");
        this.certificacionID = Objects.requireNonNull(certificacionID);
        this.nombre = Objects.requireNonNull(nombre);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public CertificacionID getCertificacionID() {
        return certificacionID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
