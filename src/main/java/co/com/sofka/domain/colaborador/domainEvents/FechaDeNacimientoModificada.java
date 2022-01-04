package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.ColaboradorID;
import co.com.sofka.domain.colaborador.values.FechaDeNacimiento;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class FechaDeNacimientoModificada extends DomainEvent {

    private final FechaDeNacimiento fechaDeNacimiento;

    public FechaDeNacimientoModificada(FechaDeNacimiento fechaDeNacimiento) {
        super("sofka.colaborador.fechadenacimientomodificada");
        this.fechaDeNacimiento = Objects.requireNonNull(fechaDeNacimiento);
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
