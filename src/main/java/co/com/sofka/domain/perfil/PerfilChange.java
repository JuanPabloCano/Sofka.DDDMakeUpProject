package co.com.sofka.domain.perfil;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.perfil.domainEvents.*;

public class PerfilChange extends EventChange {

    public PerfilChange(Perfil perfil) {

        apply((PerfilCreado event) -> {
            perfil.hojaDeVidaID = event.getHojaDeVidaID();
            perfil.informacionDeContacto = event.getInformacionDeContacto();
            perfil.fotoDePerfil = event.getFotoDePerfil();
        });

        apply((NuevaReferenciaAgregada event) -> perfil.referencias =
                (new Referencias(
                event.getReferenciasID(),
                event.getInformacionDeContacto(),
                event.getNombreCompleto()
        )));

        apply((InformacionDeContactoActualizada event) ->
                perfil.informacionDeContacto = event.getInformacionDeContacto());

        apply((FotoDePerfilActualizada event) -> perfil.fotoDePerfil = event.getFotoDePerfil());

        apply((NombreCompletoReferenciaActualizado event) ->
                perfil.referencias.nombreCompleto = event.getNombreCompleto());

        apply((InformacionDeContactoReferenciaActualizado event) ->
                perfil.referencias.informacionDeContacto = event.getInformacionDeContacto());
    }
}
