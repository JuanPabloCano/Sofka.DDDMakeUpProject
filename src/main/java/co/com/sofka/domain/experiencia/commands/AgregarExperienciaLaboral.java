package co.com.sofka.domain.experiencia.commands;

import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class AgregarExperienciaLaboral extends Command {

    private final ExperienciaLaboralID experienciaLaboralID;
    private final ExperienciaID experienciaID;
    private final Institucion institucion;
    private final Periodo periodo;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public AgregarExperienciaLaboral(ExperienciaLaboralID experienciaLaboralID, ExperienciaID experienciaID,
                                     Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        this.experienciaLaboralID = Objects.requireNonNull(experienciaLaboralID);
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public ExperienciaLaboralID getExperienciaLaboralID() {
        return experienciaLaboralID;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
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
