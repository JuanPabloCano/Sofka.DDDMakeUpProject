package co.com.sofka.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class ActualizarNombreCompletoReferencia extends Command {

    private final PerfilID perfilID;
    private final ReferenciasID referenciasID;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoReferencia(PerfilID perfilID, ReferenciasID referenciasID, NombreCompleto nombreCompleto) {
        this.perfilID = Objects.requireNonNull(perfilID);
        this.referenciasID = Objects.requireNonNull(referenciasID);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }

    public ReferenciasID getReferenciasID() {
        return referenciasID;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
