package co.com.sofka.domain.colaborador.commands;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class ModificarNombreCompleto extends Command {

    private final ColaboradorID colaboradorID;
    private final NombreCompleto nombreCompleto;

    public ModificarNombreCompleto(ColaboradorID colaboradorID, NombreCompleto nombreCompleto) {
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
