package co.com.sofka.useCases.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.perfil.Perfil;
import co.com.sofka.domain.perfil.commands.ActualizarInformacionDeContacto;

public class ActualizarInformacionDeContactoUseCase extends UseCase<RequestCommand<ActualizarInformacionDeContacto>,
        ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<ActualizarInformacionDeContacto> actualizarInformacionDeContactoRequestCommand) {

        var command = actualizarInformacionDeContactoRequestCommand.getCommand();
        var perfil = Perfil.from(command.getPerfilID(), retrieveEvents());

        perfil.actualizarInformacionDeContacto(
                command.getInformacionDeContacto()
        );
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
