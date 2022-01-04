package co.com.sofka.useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionCertificacion.GestionCertificacion;
import co.com.sofka.domain.gestionCertificacion.commands.ModificarPeriodoCertificacion;

public class ModificarPeriodoCertificacionUseCase extends UseCase<RequestCommand<ModificarPeriodoCertificacion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ModificarPeriodoCertificacion> modificarPeriodoCertificacionRequestCommand) {

        var command = modificarPeriodoCertificacionRequestCommand.getCommand();
        var certificacion = GestionCertificacion.from(command.getGestionCertificacionID(), retrieveEvents());

        certificacion.modificarPeriodoCertificacion(
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
