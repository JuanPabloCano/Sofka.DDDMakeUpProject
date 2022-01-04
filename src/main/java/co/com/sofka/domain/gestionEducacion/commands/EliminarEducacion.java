package co.com.sofka.domain.gestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;

import java.util.Objects;

public class EliminarEducacion extends Command {

    private final GestionEducacionID gestionEducacionID;
    private final EducacionesID educacionesID;

    public EliminarEducacion(GestionEducacionID gestionEducacionID, EducacionesID educacionesID) {
        this.gestionEducacionID = Objects.requireNonNull(gestionEducacionID);
        this.educacionesID = Objects.requireNonNull(educacionesID);
    }

    public GestionEducacionID getGestionEducacionID() {
        return gestionEducacionID;
    }

    public EducacionesID getEducacionesID() {
        return educacionesID;
    }
}
