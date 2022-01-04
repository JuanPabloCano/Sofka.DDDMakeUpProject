package co.com.sofka.useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionCertificacion.GestionCertificacion;
import co.com.sofka.domain.gestionCertificacion.commands.ModificarNombreCertificacion;

public class ModificarNombreCertificacionUseCase extends UseCase<RequestCommand<ModificarNombreCertificacion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ModificarNombreCertificacion> modificarNombreCertificacionRequestCommand) {

        var command = modificarNombreCertificacionRequestCommand.getCommand();
        var certificacion = GestionCertificacion.from(command.getGestionCertificacionID(), retrieveEvents());

        certificacion.modificarNombreCertificacion(
                command.getNombre()
        );
        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
