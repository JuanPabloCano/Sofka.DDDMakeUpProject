package co.com.sofka.domain.gestionEducacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.domain.gestionEducacion.values.Tipo;

import java.util.Objects;

public class TipoEducacionModificado extends DomainEvent {

    private final EducacionesID id;
    private final Tipo tipo;

    public TipoEducacionModificado(EducacionesID id, Tipo tipo) {
        super("sofka.gestioneducacion.tipoeducacionmodificado");
        this.id = Objects.requireNonNull(id);
        this.tipo = Objects.requireNonNull(tipo);
    }

    public EducacionesID getId() {
        return id;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
