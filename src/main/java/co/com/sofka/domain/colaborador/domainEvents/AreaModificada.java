package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.Area;
import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class AreaModificada extends DomainEvent {

    private final ColaboradorID colaboradorID;
    private final Area area;

    public AreaModificada(ColaboradorID colaboradorID, Area area) {
        super("sofka.colaborador.areamodificada");
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.area = Objects.requireNonNull(area);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public Area getArea() {
        return area;
    }
}
