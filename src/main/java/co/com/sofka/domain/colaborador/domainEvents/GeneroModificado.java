package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.colaborador.values.Genero;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class GeneroModificado extends DomainEvent {

    private final ColaboradorID colaboradorID;
    private final Genero genero;

    public GeneroModificado(ColaboradorID colaboradorID, Genero genero) {
        super("sofka.colaborador.generomodificado");
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.genero = Objects.requireNonNull(genero);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public Genero getGenero() {
        return genero;
    }
}
