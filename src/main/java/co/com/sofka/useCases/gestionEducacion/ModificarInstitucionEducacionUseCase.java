package co.com.sofka.useCases.gestionEducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionEducacion.GestionEducacion;
import co.com.sofka.domain.gestionEducacion.commands.ModificarInstitucionEducacion;

public class ModificarInstitucionEducacionUseCase extends UseCase<RequestCommand<ModificarInstitucionEducacion>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarInstitucionEducacion> modificarInstitucionEducacionRequestCommand) {

        var command = modificarInstitucionEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionID(), retrieveEvents());

        educacion.modificarInstitucionEducacion(
                command.getInstitucion()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
