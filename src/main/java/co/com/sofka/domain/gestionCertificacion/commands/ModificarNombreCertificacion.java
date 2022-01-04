package co.com.sofka.domain.gestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;

import java.util.Objects;

public class ModificarNombreCertificacion extends Command {

    private final GestionCertificacionID gestionCertificacionID;
    private final Nombre nombre;

    public ModificarNombreCertificacion(GestionCertificacionID gestionCertificacionID, Nombre nombre) {
        this.gestionCertificacionID = Objects.requireNonNull(gestionCertificacionID);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public GestionCertificacionID getGestionCertificacionID() {
        return gestionCertificacionID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
