package co.com.sofka.domain.gestionCertificacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.gestionCertificacion.domainEvents.*;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;

public class GestionCertificacionChange extends EventChange {

    public GestionCertificacionChange(GestionCertificacion gestionCertificacion) {

        apply((GestionCertificacionCreada event) -> gestionCertificacion.hojaDeVidaID = event.getHojaDeVidaID());

        apply((NuevaCertificacionAgregada event) ->
                gestionCertificacion.certificacion.add(
                new Certificacion(
                        event.getId(),
                        event.getNombre(),
                        event.getInstitucion(),
                        event.getPeriodo()
                )
        ));

        apply((CertificacionEliminada event) -> {
            var certificacionID = new CertificacionID();
            gestionCertificacion.certificacion.removeIf(certificacion ->
                    certificacion.certificacionID.equals(certificacionID));
        });

        apply((nombreCertificacionModificada event) -> gestionCertificacion.modificarNombreCertificacion(event.getNombre()));

        apply((InstitucionCertificacionModificada event) -> gestionCertificacion.modificarInstitucionCertificacion(
                event.getInstitucion()
        ));

        apply((PeriodoCertificacionModificado event) -> gestionCertificacion.modificarPeriodoCertificacion(
                event.getPeriodo()
        ));
    }
}
