package co.com.sofka.useCases.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.experiencia.Experiencia;
import co.com.sofka.domain.experiencia.commands.AgregarExperienciaLaboral;

public class AgregarExperienciaLaboralUseCase extends UseCase<RequestCommand<AgregarExperienciaLaboral>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarExperienciaLaboral> agregarExperienciaLaboralRequestCommand) {

        var command = agregarExperienciaLaboralRequestCommand.getCommand();
        var experiencia = Experiencia.from(command.getExperienciaID(), retrieveEvents());

        experiencia.agregarExperienciaLaboral(
                command.getInstitucion(),
                command.getPeriodo(),
                command.getConocimientosAdquiridos()
        );
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}

