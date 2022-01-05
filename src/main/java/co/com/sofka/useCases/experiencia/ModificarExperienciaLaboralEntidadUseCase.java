package co.com.sofka.useCases.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.experiencia.Experiencia;
import co.com.sofka.domain.experiencia.commands.ModificarExperienciaLaboralEntidad;

public class ModificarExperienciaLaboralEntidadUseCase extends UseCase<RequestCommand<ModificarExperienciaLaboralEntidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarExperienciaLaboralEntidad> modificarExperienciaLaboralEntidadRequestCommand) {

        var command = modificarExperienciaLaboralEntidadRequestCommand.getCommand();
        var experiencia = Experiencia.from(command.getExperienciaID(), retrieveEvents());

        experiencia.modificarExperienciaLaboralEntidad(
                command.getInstitucion()
        );
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }
}
