package co.com.sofka.domain.experiencia.domainEvents;

import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Institucion;

import java.util.Objects;

public class EntidadExperienciaLaboralModificada extends DomainEvent {

    private final ExperienciaID experienciaID;
    private final ExperienciaLaboralID experienciaLaboralID;
    private final Institucion institucion;

    public EntidadExperienciaLaboralModificada(ExperienciaID experienciaID, ExperienciaLaboralID experienciaLaboralID,
                                               Institucion institucion) {
        super("sofka.experiencia.entidadexperiencialaboralmodificada");
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.experienciaLaboralID = Objects.requireNonNull(experienciaLaboralID);
        this.institucion = Objects.requireNonNull(institucion);
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public ExperienciaLaboralID getExperienciaLaboralID() {
        return experienciaLaboralID;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
