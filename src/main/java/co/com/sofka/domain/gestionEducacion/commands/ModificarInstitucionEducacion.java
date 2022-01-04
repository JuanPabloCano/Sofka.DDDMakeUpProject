package co.com.sofka.domain.gestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.generics.Institucion;

import java.util.Objects;

public class ModificarInstitucionEducacion extends Command {

    private final GestionEducacionID gestionEducacionID;
    private final Institucion institucion;

    public ModificarInstitucionEducacion(GestionEducacionID gestionEducacionID, Institucion institucion) {
        this.gestionEducacionID = Objects.requireNonNull(gestionEducacionID);
        this.institucion = Objects.requireNonNull(institucion);
    }

    public GestionEducacionID getGestionEducacionID() {
        return gestionEducacionID;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
