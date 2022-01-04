package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.colaborador.values.Genero;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class GeneroModificado extends DomainEvent {

    private final Genero genero;

    public GeneroModificado(Genero genero) {
        super("sofka.colaborador.generomodificado");
        this.genero = Objects.requireNonNull(genero);
    }

    public Genero getGenero() {
        return genero;
    }
}
