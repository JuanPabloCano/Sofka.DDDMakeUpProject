package co.com.sofka.domain.colaborador.commands;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.colaborador.values.Genero;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class ModificarGenero extends Command {

    private final ColaboradorID colaboradorID;
    private final Genero genero;

    public ModificarGenero(ColaboradorID colaboradorID, Genero genero) {
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.genero = Objects.requireNonNull(genero);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public Genero getGenero() {
        return genero;
    }
}
