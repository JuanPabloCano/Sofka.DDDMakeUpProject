package co.com.sofka.domain.experiencia.domainEvents;

import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Institucion;

import java.util.Objects;

public class EntidadExperienciaLaboralModificada extends DomainEvent {

    private final ExperienciaLaboralID id;
    private final Institucion institucion;

    public EntidadExperienciaLaboralModificada(ExperienciaLaboralID id, Institucion institucion) {
        super("sofka.experiencia.entidadexperiencialaboralmodificada");
        this.id = Objects.requireNonNull(id);
        this.institucion = Objects.requireNonNull(institucion);
    }

    public ExperienciaLaboralID getId() {
        return id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
