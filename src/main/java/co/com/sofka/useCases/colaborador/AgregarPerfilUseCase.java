package co.com.sofka.useCases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.colaborador.Colaborador;
import co.com.sofka.domain.colaborador.commands.AgregarPerfil;

public class AgregarPerfilUseCase extends UseCase<RequestCommand<AgregarPerfil>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarPerfil> agregarPerfilRequestCommand) {
        var command = agregarPerfilRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorID(), retrieveEvents());

        colaborador.agregarPerfil(
                command.getPerfilID()
        );

        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
