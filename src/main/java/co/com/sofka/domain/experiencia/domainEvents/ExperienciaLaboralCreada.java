package co.com.sofka.domain.experiencia.domainEvents;

import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class ExperienciaLaboralCreada extends DomainEvent {

    private final ExperienciaID experienciaID;
    private final ExperienciaLaboralID experienciaLaboralID;
    private final Institucion institucion;
    private final Periodo periodo;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboralCreada(ExperienciaID experienciaID, ExperienciaLaboralID experienciaLaboralID, Institucion institucion,
                                    Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        super("sofka.experiencia.experiencialaboralcreada");
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.experienciaLaboralID = Objects.requireNonNull(experienciaLaboralID);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
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

    public Periodo getPeriodo() {
        return periodo;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
