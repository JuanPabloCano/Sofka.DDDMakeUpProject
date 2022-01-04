package co.com.sofka.domain.gestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.generics.Institucion;

import java.util.Objects;

public class ModificarInstitucionCertificacion extends Command {

    private final GestionCertificacionID gestionCertificacionID;
    private final Institucion institucion;

    public ModificarInstitucionCertificacion(GestionCertificacionID gestionCertificacionID, Institucion institucion) {
        this.gestionCertificacionID = Objects.requireNonNull(gestionCertificacionID);
        this.institucion = Objects.requireNonNull(institucion);
    }

    public GestionCertificacionID getGestionCertificacionID() {
        return gestionCertificacionID;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
