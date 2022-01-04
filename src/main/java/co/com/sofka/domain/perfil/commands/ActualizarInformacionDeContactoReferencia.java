package co.com.sofka.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;

import java.util.Objects;

public class ActualizarInformacionDeContactoReferencia extends Command {

    private final PerfilID perfilID;
    private final ReferenciasID referenciasID;
    private final InformacionDeContacto informacionDeContacto;

    public ActualizarInformacionDeContactoReferencia(PerfilID perfilID, ReferenciasID referenciasID, InformacionDeContacto informacionDeContacto) {
        this.perfilID = Objects.requireNonNull(perfilID);
        this.referenciasID = Objects.requireNonNull(referenciasID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }

    public ReferenciasID getReferenciasID() {
        return referenciasID;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
