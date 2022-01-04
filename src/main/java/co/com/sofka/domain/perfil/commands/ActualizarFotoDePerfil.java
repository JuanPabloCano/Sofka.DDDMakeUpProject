package co.com.sofka.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.perfil.values.FotoDePerfil;
import co.com.sofka.domain.perfil.values.PerfilID;

import java.util.Objects;

public class ActualizarFotoDePerfil extends Command {

    private final PerfilID perfilID;
    private final FotoDePerfil fotoDePerfil;

    public ActualizarFotoDePerfil(PerfilID perfilID, FotoDePerfil fotoDePerfil) {
        this.perfilID = Objects.requireNonNull(perfilID);
        this.fotoDePerfil = Objects.requireNonNull(fotoDePerfil);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }
}
