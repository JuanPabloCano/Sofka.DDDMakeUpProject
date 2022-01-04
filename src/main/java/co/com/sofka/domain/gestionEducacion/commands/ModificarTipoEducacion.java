package co.com.sofka.domain.gestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.domain.gestionEducacion.values.Tipo;

import java.util.Objects;

public class ModificarTipoEducacion extends Command {

    private final GestionEducacionID gestionEducacionID;
    private final Tipo tipo;

    public ModificarTipoEducacion(GestionEducacionID gestionEducacionID, Tipo tipo) {
        this.gestionEducacionID = Objects.requireNonNull(gestionEducacionID);
        this.tipo = Objects.requireNonNull(tipo);
    }

    public GestionEducacionID getGestionEducacionID() {
        return gestionEducacionID;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
