package co.com.sofka.useCases.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.perfil.Perfil;
import co.com.sofka.domain.perfil.commands.ActualizarNombreCompletoReferencia;

public class ActualizaNombreCompletoReferenciaUseCase extends UseCase<RequestCommand<ActualizarNombreCompletoReferencia>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompletoReferencia> actualizarNombreCompletoReferenciaRequestCommand) {

        var command = actualizarNombreCompletoReferenciaRequestCommand.getCommand();
        var perfil = Perfil.from(command.getPerfilID(), retrieveEvents());

        perfil.actualizarNombreCompletoReferencia(
                command.getNombreCompleto()
        );
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
