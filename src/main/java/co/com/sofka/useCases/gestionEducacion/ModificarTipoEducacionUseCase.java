package co.com.sofka.useCases.gestionEducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionEducacion.GestionEducacion;
import co.com.sofka.domain.gestionEducacion.commands.ModificarTipoEducacion;

public class ModificarTipoEducacionUseCase extends UseCase<RequestCommand<ModificarTipoEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarTipoEducacion> modificarTipoEducacionRequestCommand) {

        var command = modificarTipoEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionID(), retrieveEvents());

        educacion.modificarTipoEducacion(
                command.getTipo()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
