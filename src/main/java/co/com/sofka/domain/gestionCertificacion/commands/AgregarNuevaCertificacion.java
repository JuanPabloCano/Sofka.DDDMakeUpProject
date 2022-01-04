package co.com.sofka.domain.gestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class AgregarNuevaCertificacion extends Command {

    private final GestionCertificacionID gestionCertificacionID;
    private final Nombre nombre;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarNuevaCertificacion(GestionCertificacionID gestionCertificacionID, Nombre nombre, Institucion institucion, Periodo periodo) {
        this.gestionCertificacionID = Objects.requireNonNull(gestionCertificacionID);
        this.nombre = Objects.requireNonNull(nombre);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public GestionCertificacionID getGestionCertificacionID() {
        return gestionCertificacionID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
