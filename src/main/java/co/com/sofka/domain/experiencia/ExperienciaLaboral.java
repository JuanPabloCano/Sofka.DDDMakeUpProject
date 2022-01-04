package co.com.sofka.domain.experiencia;

import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralID> {

    protected ExperienciaLaboralID experienciaLaboralID;
    protected Institucion institucion;
    protected Periodo periodo;
    protected ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboral(ExperienciaLaboralID experienciaLaboralID, Institucion institucion, Periodo periodo,
                              ConocimientosAdquiridos conocimientosAdquiridos) {
        super(experienciaLaboralID);
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
