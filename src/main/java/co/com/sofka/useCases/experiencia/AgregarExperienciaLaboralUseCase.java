package co.com.sofka.useCases.experiencia;

import co.com.sofka.business.generic.BusinessException;
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

        if (experiencia.getExperienciaLaboral().size() > 20) {
            throw new BusinessException(command.getExperienciaLaboralID().value(), "No puede tener más de 20 " +
                    "experiencias laborales");
        }

        experiencia.agregarExperienciaLaboral(
                command.getInstitucion(),
                command.getPeriodo(),
                command.getConocimientosAdquiridos()
        );
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}

