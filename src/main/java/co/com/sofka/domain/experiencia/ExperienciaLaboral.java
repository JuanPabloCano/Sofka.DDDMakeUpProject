package co.com.sofka.domain.experiencia;

import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralID> {

    protected ExperienciaID experienciaID;
    protected ExperienciaLaboralID experienciaLaboralID;
    protected Institucion institucion;
    protected Periodo periodo;
    protected ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboral(ExperienciaID experienciaID, ExperienciaLaboralID experienciaLaboralID,
                              Institucion institucion, Periodo periodo,
                              ConocimientosAdquiridos conocimientosAdquiridos) {
        super(experienciaLaboralID);
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public void modificarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void modificarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public void modificarConocimientosAdquiridos(ConocimientosAdquiridos conocimientosAdquiridos){
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public ExperienciaID ExperienciaID() {
        return experienciaID;
    }

    public ExperienciaLaboralID ExperienciaLaboralID() {
        return experienciaLaboralID;
    }

    public Institucion Institucion() {
        return institucion;
    }

    public Periodo Periodo() {
        return periodo;
    }

    public ConocimientosAdquiridos ConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
