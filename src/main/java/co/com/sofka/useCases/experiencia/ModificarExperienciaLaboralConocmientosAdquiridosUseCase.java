package co.com.sofka.useCases.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.experiencia.Experiencia;
import co.com.sofka.domain.experiencia.commands.ModificarExperienciaLaboralConocimientosAdquiridos;

public class ModificarExperienciaLaboralConocmientosAdquiridosUseCase extends UseCase<RequestCommand<ModificarExperienciaLaboralConocimientosAdquiridos>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarExperienciaLaboralConocimientosAdquiridos> modificarExperienciaLaboralConocimientosAdquiridosRequestCommand) {

        var command = modificarExperienciaLaboralConocimientosAdquiridosRequestCommand.getCommand();
        var experiencia = Experiencia.from(command.getExperienciaID(), retrieveEvents());

        experiencia.modificarExperienciaLaboralConocimientosAdquiridos(
                command.getConocimientosAdquiridos()
        );
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }
}
