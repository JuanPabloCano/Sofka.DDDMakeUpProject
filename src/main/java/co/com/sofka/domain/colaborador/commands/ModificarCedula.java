package co.com.sofka.domain.colaborador.commands;

import co.com.sofka.domain.colaborador.values.Cedula;
import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class ModificarCedula extends Command {

    private final ColaboradorID colaboradorID;
    private final Cedula cedula;

    public ModificarCedula(ColaboradorID colaboradorID, Cedula cedula) {
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.cedula = Objects.requireNonNull(cedula);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public Cedula getCedula() {
        return cedula;
    }
}
