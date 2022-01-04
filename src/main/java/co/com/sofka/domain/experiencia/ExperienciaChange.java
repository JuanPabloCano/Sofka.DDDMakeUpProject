package co.com.sofka.domain.experiencia;

import co.com.sofka.domain.experiencia.domainEvents.*;
import co.com.sofka.domain.generic.EventChange;

public class ExperienciaChange extends EventChange {

    public ExperienciaChange(Experiencia experiencia) {

        apply((ExperienciaCreada event) -> experiencia.hojaDeVidaID = event.getHojaDeVidaID());

        apply((ExperienciaLaboralCreada event) -> experiencia.experienciaLaboral.add(
                new ExperienciaLaboral(
                event.getId(),
                event.getInstitucion(),
                event.getPeriodo(),
                event.getConocimientosAdquiridos()
        )));

        apply((ExperienciaLaboralEliminada event) -> {
            var idExperienciaLaboral = event.getExperienciaLaboralID();
            experiencia.experienciaLaboral.removeIf(experienciaLaboral ->
                    experienciaLaboral.ExperienciaLaboralID()
                    .equals(idExperienciaLaboral));
        });

        apply((EntidadExperienciaLaboralModificada event) ->
                experiencia.modificarExperienciaLaboralEntidad(
                event.getInstitucion()
        ));

        apply((PeriodoExperienciaLaboralModificada event) ->
                experiencia.modificarExperienciaLaboralPeriodo(
                        event.getPeriodo()
                ));

        apply((ConocimientosAdquiridosExperienciaLaboralModificada event) ->
                experiencia.modificarExperienciaLaboralConocimientosAdquiridos(
                        event.getConocimientosAdquiridos()
                ));
    }
}
