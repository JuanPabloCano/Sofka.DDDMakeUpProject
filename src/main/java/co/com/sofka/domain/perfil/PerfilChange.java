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

        apply((NuevaReferenciaAgregada event) -> {
            perfil.referencias.add(new Referencias(
                    event.getReferenciasID(),
                    event.getInformacionDeContacto(),
                    event.getNombreCompleto()
            ));
        });

        apply((ReferenciaEliminada event) ->{
            var referenciaID = event.getReferenciasID();
            perfil.referencias.removeIf(referencia -> referencia.ReferenciasID().equals(referenciaID));
        });

        apply((InformacionDeContactoActualizada event) ->
                perfil.actualizarInformacionDeContacto(event.getInformacionDeContacto()));

        apply((FotoDePerfilActualizada event) -> perfil.actualizarFotoDePerfil(event.getFotoDePerfil()));

        apply((NombreCompletoReferenciaActualizado event) ->
                perfil.actualizarNombreCompletoReferencia(
                event.getNombreCompleto()));

        apply((InformacionDeContactoReferenciaActualizado event) ->
                perfil.actualizarInformacionDeContactoReferencia(
                event.getInformacionDeContacto()
        ));
    }
}
