package co.com.sofka.useCases.triggeredEventUseCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.perfil.Perfil;
import co.com.sofka.domain.perfil.domainEvents.InformacionDeContactoActualizada;

public class InformacionDeContactoActualizadaTriggeredEventUseCase extends UseCase<TriggeredEvent<InformacionDeContactoActualizada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<InformacionDeContactoActualizada> informacionDeContactoActualizadaTriggeredEvent) {

        var event = informacionDeContactoActualizadaTriggeredEvent.getDomainEvent();
        var informacionContacto = Perfil.from(event.getPerfilID(), retrieveEvents());

        informacionContacto.actualizarInformacionDeContacto(
                event.getInformacionDeContacto()
        );
        emit().onResponse(new ResponseEvents(informacionContacto.getUncommittedChanges()));
    }
}
