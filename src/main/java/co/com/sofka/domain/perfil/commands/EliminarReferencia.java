package co.com.sofka.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;

import java.util.Objects;

public class EliminarReferencia extends Command {

    private final PerfilID perfilID;
    private final ReferenciasID referenciasID;

    public EliminarReferencia(PerfilID perfilID, ReferenciasID referenciasID) {
        this.perfilID = Objects.requireNonNull(perfilID);
        this.referenciasID = Objects.requireNonNull(referenciasID);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }

    public ReferenciasID getReferenciasID() {
        return referenciasID;
    }
}
