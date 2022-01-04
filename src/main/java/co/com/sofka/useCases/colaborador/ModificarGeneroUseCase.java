package co.com.sofka.useCases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.colaborador.Colaborador;
import co.com.sofka.domain.colaborador.commands.ModificarGenero;

public class ModificarGeneroUseCase extends UseCase<RequestCommand<ModificarGenero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarGenero> modificarGeneroRequestCommand) {

        var command = modificarGeneroRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorID(), retrieveEvents());

        colaborador.modificarGenero(command.getGenero());
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}

