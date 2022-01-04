package co.com.sofka.useCases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.colaborador.Colaborador;
import co.com.sofka.domain.colaborador.commands.ModificarArea;

public class ModificarAreaUseCase extends UseCase<RequestCommand<ModificarArea>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarArea> modificarAreaRequestCommand) {
        var command = modificarAreaRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorID(), retrieveEvents());

        colaborador.modificarArea(
                command.getArea()
        );
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
