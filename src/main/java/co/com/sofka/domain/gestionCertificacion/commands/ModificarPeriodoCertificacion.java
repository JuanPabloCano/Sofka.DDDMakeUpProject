package co.com.sofka.domain.gestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class ModificarPeriodoCertificacion extends Command {

    private final GestionCertificacionID gestionCertificacionID;
    private final Periodo periodo;

    public ModificarPeriodoCertificacion(GestionCertificacionID gestionCertificacionID, Periodo periodo) {
        this.gestionCertificacionID = Objects.requireNonNull(gestionCertificacionID);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public GestionCertificacionID getGestionCertificacionID() {
        return gestionCertificacionID;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
