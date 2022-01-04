package co.com.sofka.domain.gestionEducacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.domain.gestionEducacion.values.Estudio;

import java.util.Objects;

public class EstudioEducacionModificado extends DomainEvent {

    private final EducacionesID id;
    private final Estudio estudio;

    public EstudioEducacionModificado(EducacionesID id, Estudio estudio) {
        super("sofka.gestioneducacion.estudioeducacionmodificado");
        this.id = Objects.requireNonNull(id);
        this.estudio = Objects.requireNonNull(estudio);
    }

    public EducacionesID getId() {
        return id;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
