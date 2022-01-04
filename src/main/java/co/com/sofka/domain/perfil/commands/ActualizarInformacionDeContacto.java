package co.com.sofka.domain.perfil.commands;

import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;

import java.util.Objects;

public class ActualizarInformacionDeContacto {

    private final PerfilID perfilID;
    private final InformacionDeContacto informacionDeContacto;

    public ActualizarInformacionDeContacto(PerfilID perfilID, InformacionDeContacto informacionDeContacto) {
        this.perfilID = Objects.requireNonNull(perfilID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public PerfilID getPerfilID() {
        return perfilID;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
