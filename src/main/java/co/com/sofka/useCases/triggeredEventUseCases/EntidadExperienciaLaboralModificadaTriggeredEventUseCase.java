package co.com.sofka.useCases.triggeredEventUseCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.experiencia.Experiencia;
import co.com.sofka.domain.experiencia.domainEvents.EntidadExperienciaLaboralModificada;

public class EntidadExperienciaLaboralModificadaTriggeredEventUseCase extends UseCase<TriggeredEvent<EntidadExperienciaLaboralModificada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EntidadExperienciaLaboralModificada> entidadExperienciaLaboralModificadaTriggeredEvent) {

        var event = entidadExperienciaLaboralModificadaTriggeredEvent.getDomainEvent();
        var entidadExperiencia = Experiencia.from(event.getExperienciaID(), retrieveEvents());

        entidadExperiencia.modificarExperienciaLaboralEntidad(
                event.getInstitucion()
        );
        emit().onResponse(new ResponseEvents(entidadExperiencia.getUncommittedChanges()));
    }
}
