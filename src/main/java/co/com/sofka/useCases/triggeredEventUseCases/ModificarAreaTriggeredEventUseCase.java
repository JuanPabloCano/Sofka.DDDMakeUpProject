package co.com.sofka.useCases.triggeredEventUseCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.colaborador.Colaborador;
import co.com.sofka.domain.colaborador.domainEvents.AreaModificada;


public class ModificarAreaTriggeredEventUseCase extends UseCase<TriggeredEvent<AreaModificada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<AreaModificada> areaModificadaTriggeredEvent) {

         var event = areaModificadaTriggeredEvent.getDomainEvent();

         var colaboradorArea = Colaborador.from(event.getColaboradorID(), retrieveEvents());

         colaboradorArea.modificarArea(
                 event.getArea()
         );
         emit().onResponse(new ResponseEvents(colaboradorArea.getUncommittedChanges()));
    }
}

