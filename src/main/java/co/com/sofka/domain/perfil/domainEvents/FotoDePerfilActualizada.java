package co.com.sofka.domain.perfil.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.FotoDePerfil;

import java.util.Objects;

public class FotoDePerfilActualizada extends DomainEvent {

    private final FotoDePerfil fotoDePerfil;

    public FotoDePerfilActualizada(FotoDePerfil fotoDePerfil) {
        super("sofka.perfil.fotodeperfilactualizada");
        this.fotoDePerfil = Objects.requireNonNull(fotoDePerfil);
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }
}
