package co.com.sofka.domain.colaborador;

import co.com.sofka.domain.colaborador.domainEvents.*;
import co.com.sofka.domain.generic.EventChange;

public class ColaboradorChange extends EventChange {

    public ColaboradorChange(Colaborador colaborador) {

        apply((ColaboradorCreado event) -> {
            colaborador.colaboradorID = event.getColaboradorID();
            colaborador.hojaDeVidaID = event.getHojaDeVidID();
            colaborador.fechaDeNacimiento = event.getFechaDeNacimiento();
            colaborador.nombreCompleto = event.getNombreCompleto();
            colaborador.cedula = event.getCedula();
            colaborador.genero = event.getGenero();
            colaborador.area = event.getArea();
        });

        apply((PerfilAgregado event) -> colaborador.perfilID = event.getPerfilID());

        apply((FechaDeNacimientoModificada event) -> colaborador.modificarFechaDeNacimiento(
                event.getFechaDeNacimiento()));

        apply((NombreCompletoModificado event) ->
                colaborador.modificarNombreCompleto(event.getNombreCompleto()));

        apply((CedulaModificada event) -> colaborador.modificarCedula(event.getCedula()));

        apply((GeneroModificado event) -> colaborador.modificarGenero(event.getGenero()));

        apply((AreaModificada event) -> colaborador.modificarArea(event.getArea()));
    }
}
