package co.com.sofka.domain.gestionEducacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.generics.Institucion;

import java.util.Objects;

public class InstitucionEducacionModificada extends DomainEvent {

    private final EducacionesID id;
    private final Institucion institucion;

    public InstitucionEducacionModificada(EducacionesID id, Institucion institucion) {
        super("sofka.gestioneducacion.institucioneducacionmodificado");
        this.id = Objects.requireNonNull(id);
        this.institucion = Objects.requireNonNull(institucion);
    }

    public EducacionesID getId() {
        return id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
