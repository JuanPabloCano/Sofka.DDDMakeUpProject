package co.com.sofka.useCases.gestionEducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionEducacion.GestionEducacion;
import co.com.sofka.domain.gestionEducacion.commands.ActualizarPeriodoEducacion;

public class ActualizarPeriodoEducacionUseCase extends UseCase<RequestCommand<ActualizarPeriodoEducacion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarPeriodoEducacion> actualizarPeriodoEducacionRequestCommand) {

        var command = actualizarPeriodoEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionID(), retrieveEvents());

        educacion.actualizarPeriodoEducacion(
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
