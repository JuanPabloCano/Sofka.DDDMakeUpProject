package co.com.sofka.useCases.perfil;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.perfil.Perfil;
import co.com.sofka.domain.perfil.commands.AgregarNuevaReferencia;

public class AgregarNuevaReferenciaUseCase extends UseCase<RequestCommand<AgregarNuevaReferencia>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaReferencia> agregarNuevaReferenciaRequestCommand) {

        var command = agregarNuevaReferenciaRequestCommand.getCommand();
        var perfil = Perfil.from(command.getPerfilID(), retrieveEvents());

        if (perfil.Referencias().size() > 4){
            throw new BusinessException(command.getReferenciasID().value(), "No puede tener más de 4 referencias");
        }
        perfil.agregarNuevaReferencia(
                command.getInformacionDeContacto(),
                command.getNombreCompleto()
        );
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
