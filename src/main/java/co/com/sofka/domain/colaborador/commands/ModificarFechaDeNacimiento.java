package co.com.sofka.domain.colaborador.commands;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.colaborador.values.FechaDeNacimiento;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class ModificarFechaDeNacimiento extends Command {

    private final ColaboradorID colaboradorID;
    private final FechaDeNacimiento fechaDeNacimiento;

    public ModificarFechaDeNacimiento(ColaboradorID colaboradorID, FechaDeNacimiento fechaDeNacimiento) {
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.fechaDeNacimiento = Objects.requireNonNull(fechaDeNacimiento);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
