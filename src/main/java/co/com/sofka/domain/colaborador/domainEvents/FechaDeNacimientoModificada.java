package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.colaborador.values.FechaDeNacimiento;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class FechaDeNacimientoModificada extends DomainEvent {

    private final ColaboradorID colaboradorID;
    private final FechaDeNacimiento fechaDeNacimiento;

    public FechaDeNacimientoModificada(ColaboradorID colaboradorID, FechaDeNacimiento fechaDeNacimiento) {
        super("sofka.colaborador.fechadenacimientomodificada");
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
