package co.com.sofka.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject<String> {

    private final String genero;

    public Genero(String genero) {
        this.genero = Objects.requireNonNull(genero, "El género es requerido");

        if (this.genero.isBlank()){
            throw new IllegalArgumentException("El género no puede estar en vacío");
        }

        if (this.genero.length() <= 0 || this.genero.length() >= 20){
            throw new IllegalArgumentException("El género no puede ser menor o igual a cero ni mayor a 20");
        }

    }

    @Override
    public String value() {
        return genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero1 = (Genero) o;
        return Objects.equals(genero, genero1.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genero);
    }
}
