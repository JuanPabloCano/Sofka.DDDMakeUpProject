package co.com.sofka.domain.experiencia.domainEvents;

import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class ConocimientosAdquiridosExperienciaLaboralModificada extends DomainEvent {

    private final ExperienciaLaboralID id;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public ConocimientosAdquiridosExperienciaLaboralModificada(ExperienciaLaboralID id, ConocimientosAdquiridos conocimientosAdquiridos) {
        super("sofka.experiencia.conocimientosadquiridosexperiencialaboralmodificada");
        this.id = Objects.requireNonNull(id);
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public ExperienciaLaboralID getId() {
        return id;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
