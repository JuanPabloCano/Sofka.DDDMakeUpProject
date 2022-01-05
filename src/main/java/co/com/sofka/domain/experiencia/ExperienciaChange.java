package co.com.sofka.domain.experiencia;

import co.com.sofka.domain.experiencia.domainEvents.*;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.generics.Institucion;

public class ExperienciaChange extends EventChange {

    public ExperienciaChange(Experiencia experiencia) {

        apply((ExperienciaCreada event) -> experiencia.hojaDeVidaID = event.getHojaDeVidaID());

        apply((ExperienciaLaboralCreada event) -> experiencia.experienciaLaboral =
                        new ExperienciaLaboral(
                        event.getExperienciaID(),
                        event.getExperienciaLaboralID(),
                        event.getInstitucion(),
                        event.getPeriodo(),
                        event.getConocimientosAdquiridos()
        ));

        apply((EntidadExperienciaLaboralModificada event) ->
                experiencia.experienciaLaboral.institucion = event.getInstitucion());

        apply((PeriodoExperienciaLaboralModificada event) ->
                experiencia.experienciaLaboral.periodo = event.getPeriodo());

        apply((ConocimientosAdquiridosExperienciaLaboralModificada event) ->
                experiencia.experienciaLaboral.conocimientosAdquiridos = event.getConocimientosAdquiridos());
    }
}
