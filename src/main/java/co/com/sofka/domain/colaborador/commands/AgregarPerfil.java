package co.com.sofka.domain.colaborador.commands;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.perfil.values.PerfilID;

import java.util.Objects;

public class AgregarPerfil extends Command {

    private final ColaboradorID colaboradorID;
    private final PerfilID perfilID;

    public AgregarPerfil(ColaboradorID colaboradorID, PerfilID perfilID) {
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.perfilID = Objects.requireNonNull(perfilID);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }
}
