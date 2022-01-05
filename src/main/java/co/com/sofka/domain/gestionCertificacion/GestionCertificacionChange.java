package co.com.sofka.domain.gestionCertificacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.gestionCertificacion.domainEvents.*;

public class GestionCertificacionChange extends EventChange {

    public GestionCertificacionChange(GestionCertificacion gestionCertificacion) {

        apply((GestionCertificacionCreada event) -> gestionCertificacion.hojaDeVidaID = event.getHojaDeVidaID());

        apply((NuevaCertificacionAgregada event) ->
                gestionCertificacion.certificacion = new Certificacion(
                        event.getCertificacionID(),
                        event.getNombre(),
                        event.getInstitucion(),
                        event.getPeriodo()
                )
        );

        apply((NombreCertificacionModificada event) -> gestionCertificacion.certificacion.nombre = event.getNombre());

        apply((InstitucionCertificacionModificada event) -> gestionCertificacion.certificacion.institucion = event.getInstitucion()
        );

        apply((PeriodoCertificacionModificado event) -> gestionCertificacion.certificacion.periodo = event.getPeriodo());
    }
}
