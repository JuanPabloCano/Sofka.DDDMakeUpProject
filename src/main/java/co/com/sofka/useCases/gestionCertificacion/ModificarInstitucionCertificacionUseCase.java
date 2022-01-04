package co.com.sofka.useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.gestionCertificacion.GestionCertificacion;
import co.com.sofka.domain.gestionCertificacion.commands.ModificarInstitucionCertificacion;

public class ModificarInstitucionCertificacionUseCase extends UseCase<RequestCommand<ModificarInstitucionCertificacion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ModificarInstitucionCertificacion> modificarInstitucionCertificacionRequestCommand) {

        var command = modificarInstitucionCertificacionRequestCommand.getCommand();
        var certificacion = GestionCertificacion.from(command.getGestionCertificacionID(), retrieveEvents());

        certificacion.modificarInstitucionCertificacion(
                command.getInstitucion()
        );
        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
