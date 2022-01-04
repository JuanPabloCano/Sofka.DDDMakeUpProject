package co.com.sofka.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaDeNacimiento implements ValueObject<String> {

    private final LocalDate fechaDeNacimiento;
    private final String format;

    public FechaDeNacimiento(int day, int month, int year){

        try {
            fechaDeNacimiento = LocalDate.of(year, month, day);
            if(fechaDeNacimiento.isAfter(LocalDate.now())){
                throw new IllegalArgumentException("La fecha ingresada no es válida");
            }
        } catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        format = generateFormat();
    }

    private String generateFormat() {
        return fechaDeNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaDeNacimiento that = (FechaDeNacimiento) o;
        return Objects.equals(fechaDeNacimiento, that.fechaDeNacimiento) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaDeNacimiento, format);
    }

    @Override
    public String value() {
        return format;
    }
}
