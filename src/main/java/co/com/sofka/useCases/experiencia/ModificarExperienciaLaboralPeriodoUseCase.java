package co.com.sofka.useCases.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.experiencia.Experiencia;
import co.com.sofka.domain.experiencia.commands.ModificarExperienciaLaboralPeriodo;

public class ModificarExperienciaLaboralPeriodoUseCase extends UseCase<RequestCommand<ModificarExperienciaLaboralPeriodo>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ModificarExperienciaLaboralPeriodo> modificarExperienciaLaboralPeriodoRequestCommand) {

        var command = modificarExperienciaLaboralPeriodoRequestCommand.getCommand();
        var experiencia = Experiencia.from(command.getExperienciaID(), retrieveEvents());

        experiencia.modificarExperienciaLaboralPeriodo(command.getPeriodo());
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
