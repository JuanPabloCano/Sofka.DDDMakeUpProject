package co.com.sofka.useCases.gestionCertificacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.experiencia.Experiencia;
import co.com.sofka.domain.gestionCertificacion.GestionCertificacion;
import co.com.sofka.domain.gestionCertificacion.commands.AgregarNuevaCertificacion;

public class AgregarNuevaCertificacionUseCase extends UseCase<RequestCommand<AgregarNuevaCertificacion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaCertificacion> agregarNuevaCertificacionRequestCommand) {

        var command = agregarNuevaCertificacionRequestCommand.getCommand();
        var certificacion = GestionCertificacion.from(command.getGestionCertificacionID(), retrieveEvents());

        if (certificacion.getCertificacion().size() > 10){
            throw new BusinessException(command.getCertificacionID().value(), "No puede tener más de 10 " +
                    "certificaciones");
        }
        certificacion.agregarNuevaCertificacion(
                command.getNombre(),
                command.getInstitucion(),
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
