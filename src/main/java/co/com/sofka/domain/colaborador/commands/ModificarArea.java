package co.com.sofka.domain.colaborador.commands;

import co.com.sofka.domain.colaborador.values.Area;
import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class ModificarArea extends Command {

    private final ColaboradorID colaboradorID;
    private final Area area;

    public ModificarArea(ColaboradorID colaboradorID, Area area) {
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
