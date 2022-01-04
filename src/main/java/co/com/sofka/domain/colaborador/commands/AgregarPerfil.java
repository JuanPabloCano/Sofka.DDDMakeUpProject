package co.com.sofka.domain.colaborador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.perfil.values.PerfilID;

import java.util.Objects;

public class AgregarPerfil extends Command {

    private final PerfilID perfilID;

    public AgregarPerfil(PerfilID perfilID) {
        this.perfilID = Objects.requireNonNull(perfilID);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }
}
