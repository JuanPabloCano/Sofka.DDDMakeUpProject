package co.com.sofka.domain.gestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionEducacion.values.Estudio;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;

import java.util.Objects;

public class ModificarEstudioEducacion extends Command {

    private final GestionEducacionID gestionEducacionID;
    private final Estudio estudio;

    public ModificarEstudioEducacion(GestionEducacionID gestionEducacionID, Estudio estudio) {
        this.gestionEducacionID = Objects.requireNonNull(gestionEducacionID);
        this.estudio = Objects.requireNonNull(estudio);
    }

    public GestionEducacionID getGestionEducacionID() {
        return gestionEducacionID;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
