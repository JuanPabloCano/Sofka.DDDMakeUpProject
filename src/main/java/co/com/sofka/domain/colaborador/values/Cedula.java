package co.com.sofka.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cedula implements ValueObject<String> {

    private final String numeroCedula;

    public Cedula(String numeroCedula) {
        this.numeroCedula = Objects.requireNonNull(numeroCedula, "El número de cédula es requerido");

        if (this.numeroCedula.isBlank()){
            throw new IllegalArgumentException("La cédula no puede estar en vacía");
        }

        if (this.numeroCedula.length() <= 0 || this.numeroCedula.length() >= 20){
            throw new IllegalArgumentException("El número de cédula no puede ser menor o igual a cero ni mayor a 20");
        }
    }

    @Override
    public String value() {
        return numeroCedula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cedula cedula = (Cedula) o;
        return Objects.equals(numeroCedula, cedula.numeroCedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCedula);
    }
}
