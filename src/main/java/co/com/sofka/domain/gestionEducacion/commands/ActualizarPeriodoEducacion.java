package co.com.sofka.domain.gestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class ActualizarPeriodoEducacion extends Command {

    private final GestionEducacionID gestionEducacionID;
    private final Periodo periodo;

    public ActualizarPeriodoEducacion(GestionEducacionID gestionEducacionID, Periodo periodo) {
        this.gestionEducacionID = Objects.requireNonNull(gestionEducacionID);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public GestionEducacionID getGestionEducacionID() {
        return gestionEducacionID;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
