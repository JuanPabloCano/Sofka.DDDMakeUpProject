package co.com.sofka.domain.gestionEducacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.gestionEducacion.domainEvents.*;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;

public class GestionEducacionChange extends EventChange {

    public GestionEducacionChange(GestionEducacion gestionEducacion) {

        apply((GestionEducacionCreada event) -> gestionEducacion.hojaDeVidaID = event.getHojaDeVidaID());

        apply((EducacionAgregada event) -> gestionEducacion.educaciones = (
                new Educaciones(
                event.getId(),
                event.getTipo(),
                event.getEstudio(),
                event.getInstitucion(),
                event.getPeriodo()
        )));

        apply((TipoEducacionModificado event) -> gestionEducacion.educaciones.tipo = event.getTipo());

        apply((EstudioEducacionModificado event) -> gestionEducacion.educaciones.estudio = event.getEstudio());

        apply((PeriodoEducacionModificado event) -> gestionEducacion.educaciones.periodo = event.getPeriodo());

        apply((InstitucionEducacionModificada event) -> gestionEducacion.educaciones.institucion = event.getInstitucion());
    }
}
