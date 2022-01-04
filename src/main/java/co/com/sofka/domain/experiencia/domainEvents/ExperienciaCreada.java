package co.com.sofka.domain.experiencia.domainEvents;

import co.com.sofka.domain.experiencia.ExperienciaLaboral;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.HojaDeVidaID;

import java.util.Objects;

public class ExperienciaCreada extends DomainEvent {

    private final ExperienciaID experienciaID;
    private final HojaDeVidaID hojaDeVidaID;

    public ExperienciaCreada(ExperienciaID experienciaID, HojaDeVidaID hojaDeVidaID ) {
        super("sofka.experiencia.experienciacreada");
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.hojaDeVidaID = Objects.requireNonNull(hojaDeVidaID);
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public HojaDeVidaID getHojaDeVidaID() {
        return hojaDeVidaID;
    }
}
