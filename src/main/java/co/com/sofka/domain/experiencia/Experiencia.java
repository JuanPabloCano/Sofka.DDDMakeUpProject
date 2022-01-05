package co.com.sofka.domain.experiencia;

import co.com.sofka.domain.experiencia.domainEvents.*;
import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Experiencia extends AggregateEvent<ExperienciaID> {

    protected HojaDeVidaID hojaDeVidaID;
    protected ExperienciaLaboral experienciaLaboral;

    private Experiencia(ExperienciaID experienciaID) {
        super(experienciaID);
        subscribe(new ExperienciaChange(this));
    }

    public Experiencia(ExperienciaID experienciaID, HojaDeVidaID hojaDeVidaID) {
        super(experienciaID);
        appendChange(new ExperienciaCreada(experienciaID, hojaDeVidaID)).apply();
    }

    public static Experiencia from(ExperienciaID experienciaID, List<DomainEvent> events){
        var experiencia = new Experiencia(experienciaID);
        events.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void agregarExperienciaLaboral(ExperienciaID experienciaID, ExperienciaLaboralID experienciaLaboralID,
                                          Institucion institucion,
                                          Periodo periodo,
                                          ConocimientosAdquiridos conocimientosAdquiridos){
        Objects.requireNonNull(experienciaID);
        Objects.requireNonNull(experienciaLaboralID);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        Objects.requireNonNull(conocimientosAdquiridos);
        appendChange(new ExperienciaLaboralCreada(experienciaID, experienciaLaboralID, institucion, periodo,
                conocimientosAdquiridos)).apply();
    }

    public void modificarExperienciaLaboralEntidad(Institucion institucion){
        var id = new ExperienciaLaboralID();
        Objects.requireNonNull(institucion);
        appendChange(new EntidadExperienciaLaboralModificada(id, institucion)).apply();
    }

    public void modificarExperienciaLaboralPeriodo(Periodo periodo) {
        var id = new ExperienciaLaboralID();
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoExperienciaLaboralModificada(id, periodo)).apply();
    }

    public void modificarExperienciaLaboralConocimientosAdquiridos(ConocimientosAdquiridos conocimientosAdquiridos) {
        var id = new ExperienciaLaboralID();
        Objects.requireNonNull(conocimientosAdquiridos);
        appendChange(new ConocimientosAdquiridosExperienciaLaboralModificada(id, conocimientosAdquiridos)).apply();
    }

    public HojaDeVidaID HojaDeVidaID() {
        return hojaDeVidaID;
    }

    public ExperienciaLaboral ExperienciaLaboral() {
        return experienciaLaboral;
    }
}
