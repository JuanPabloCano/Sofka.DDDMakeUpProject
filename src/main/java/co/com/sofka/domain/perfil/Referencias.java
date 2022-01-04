package co.com.sofka.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class Referencias extends Entity<ReferenciasID> {

    protected ReferenciasID referenciasID;
    protected InformacionDeContacto informacionDeContacto;
    protected NombreCompleto nombreCompleto;

    public Referencias(ReferenciasID referenciasID, InformacionDeContacto informacionDeContacto, NombreCompleto nombreCompleto) {
        super(referenciasID);
        this.referenciasID = Objects.requireNonNull(referenciasID);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public void actualizarInformacionDeContacto(InformacionDeContacto informacionDeContacto){
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public ReferenciasID ReferenciasID() {
        return referenciasID;
    }

    public InformacionDeContacto InformacionDeContacto() {
        return informacionDeContacto;
    }

    public NombreCompleto NombreCompleto() {
        return nombreCompleto;
    }
}
