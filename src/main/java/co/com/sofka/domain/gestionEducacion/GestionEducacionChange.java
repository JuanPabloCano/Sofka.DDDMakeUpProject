package co.com.sofka.domain.gestionEducacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.gestionEducacion.domainEvents.*;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;

public class GestionEducacionChange extends EventChange {

    public GestionEducacionChange(GestionEducacion gestionEducacion) {

        apply((GestionEducacionCreada event) -> gestionEducacion.hojaDeVidaID = event.getHojaDeVidaID());

        apply((EducacionAgregada event) -> gestionEducacion.educaciones.add(
                new Educaciones(
                event.getId(),
                event.getTipo(),
                event.getEstudio(),
                event.getInstitucion(),
                event.getPeriodo()
        )));

        apply((EducacionEliminada event) -> {
            var educacionID = new EducacionesID();
            gestionEducacion.educaciones.removeIf(educaciones ->
                    educaciones.educacionesID.equals(educacionID));
        });

        apply((TipoEducacionModificado event) -> gestionEducacion.modificarTipoEducacion(
                event.getTipo()
        ));

        apply((EstudioEducacionModificado event) -> gestionEducacion.modificarEstudioEducacion(
                event.getEstudio()
        ));

        apply((PeriodoEducacionModificado event) -> gestionEducacion.actualizarPeriodoEducacion(
                event.getPeriodo()
        ));

        apply((InstitucionEducacionModificada event) -> gestionEducacion.modificarInstitucionEducacion(
                event.getInstitucion()
        ));
    }
}
