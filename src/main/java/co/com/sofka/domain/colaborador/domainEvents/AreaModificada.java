package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.Area;
import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class AreaModificada extends DomainEvent {

    private final Area area;

    public AreaModificada(Area area) {
        super("sofka.colaborador.areamodificada");
        this.area = Objects.requireNonNull(area);
    }

    public Area getArea() {
        return area;
    }
}
