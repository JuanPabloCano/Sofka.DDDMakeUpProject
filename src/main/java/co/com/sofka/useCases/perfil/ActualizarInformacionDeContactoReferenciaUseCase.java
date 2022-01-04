package co.com.sofka.useCases.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.perfil.Perfil;
import co.com.sofka.domain.perfil.commands.ActualizarInformacionDeContactoReferencia;

public class ActualizarInformacionDeContactoReferenciaUseCase extends UseCase<RequestCommand<ActualizarInformacionDeContactoReferencia>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarInformacionDeContactoReferencia> actualizarInformacionDeContactoReferenciaRequestCommand) {

        var command = actualizarInformacionDeContactoReferenciaRequestCommand.getCommand();
        var perfil = Perfil.from(command.getPerfilID(), retrieveEvents());

        perfil.actualizarInformacionDeContactoReferencia(
                command.getInformacionDeContacto()
        );
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
