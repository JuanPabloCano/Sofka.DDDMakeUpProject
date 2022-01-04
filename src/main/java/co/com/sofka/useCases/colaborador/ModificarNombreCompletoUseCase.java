package co.com.sofka.useCases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.colaborador.Colaborador;
import co.com.sofka.domain.colaborador.commands.ModificarNombreCompleto;

public class ModificarNombreCompletoUseCase extends UseCase<RequestCommand<ModificarNombreCompleto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarNombreCompleto> modificarNombreCompletoRequestCommand) {

        var command = modificarNombreCompletoRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorID(), retrieveEvents());

        colaborador.modificarNombreCompleto(command.getNombreCompleto());
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
