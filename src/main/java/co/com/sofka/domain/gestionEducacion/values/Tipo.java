package co.com.sofka.domain.gestionEducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {

    private final String tipo;

    public Tipo(String tipo) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo es requerido");

        if (this.tipo.isBlank()){
            throw new IllegalArgumentException("El tipo no puede estar vacío");
        }

        if (this.tipo.length() <= 0 || this.tipo.length() >= 50){
            throw new IllegalArgumentException("El tipo no puede ser menor o igual a cero ni " +
                    "mayor a 50");
        }

    }

    @Override
    public String value() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo1 = (Tipo) o;
        return Objects.equals(tipo, tipo1.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
