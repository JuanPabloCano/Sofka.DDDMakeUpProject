package co.com.sofka.useCases.gestionEducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionEducacion.GestionEducacion;
import co.com.sofka.domain.gestionEducacion.commands.ModificarEstudioEducacion;

public class ModificarEstudioEducacionUseCase extends UseCase<RequestCommand<ModificarEstudioEducacion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ModificarEstudioEducacion> modificarEstudioEducacionRequestCommand) {

        var command = modificarEstudioEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionID(), retrieveEvents());

        educacion.modificarEstudioEducacion(
                command.getEstudio()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
