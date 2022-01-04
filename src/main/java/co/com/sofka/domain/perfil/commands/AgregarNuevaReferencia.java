package co.com.sofka.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class AgregarNuevaReferencia extends Command {

    private final PerfilID perfilID;
    private final ReferenciasID referenciasID;
    private final InformacionDeContacto informacionDeContacto;
    private final NombreCompleto nombreCompleto;

    public AgregarNuevaReferencia(PerfilID perfilID, ReferenciasID referenciasID, InformacionDeContacto informacionDeContacto, NombreCompleto nombreCompleto) {
        this.perfilID = Objects.requireNonNull(perfilID);
        this.referenciasID = Objects.requireNonNull(referenciasID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
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

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
