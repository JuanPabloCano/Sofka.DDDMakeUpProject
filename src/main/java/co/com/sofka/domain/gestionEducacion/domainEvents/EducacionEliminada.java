package co.com.sofka.domain.gestionEducacion.domainEvents;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;

import java.util.Objects;

public class EducacionEliminada extends DomainEvent {

    private final EducacionesID educacionesID;

    public EducacionEliminada(EducacionesID educacionesID) {
        super("sofka.gestioneducacion.educacioneliminada");
        this.educacionesID = Objects.requireNonNull(educacionesID);
    }

    public EducacionesID getEducacionesID() {
        return educacionesID;
    }
}
