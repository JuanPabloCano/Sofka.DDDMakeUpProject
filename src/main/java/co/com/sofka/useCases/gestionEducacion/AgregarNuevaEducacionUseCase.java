package co.com.sofka.useCases.gestionEducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionEducacion.GestionEducacion;
import co.com.sofka.domain.gestionEducacion.commands.AgregarNuevaEducacion;

public class AgregarNuevaEducacionUseCase extends UseCase<RequestCommand<AgregarNuevaEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaEducacion> agregarNuevaEducacionRequestCommand) {

        var command = agregarNuevaEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionID(), retrieveEvents());

        educacion.agregarNuevaEducacion(
                command.getTipo(),
                command.getEstudio(),
                command.getInstitucion(),
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
