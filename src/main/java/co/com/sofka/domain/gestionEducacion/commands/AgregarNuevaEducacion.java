package co.com.sofka.domain.gestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionEducacion.values.Estudio;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.domain.gestionEducacion.values.Tipo;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class AgregarNuevaEducacion extends Command {

    private final GestionEducacionID gestionEducacionID;
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarNuevaEducacion(GestionEducacionID gestionEducacionID, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        this.gestionEducacionID = Objects.requireNonNull(gestionEducacionID);
        this.tipo = Objects.requireNonNull(tipo);
        this.estudio = Objects.requireNonNull(estudio);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public GestionEducacionID getGestionEducacionID() {
        return gestionEducacionID;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
