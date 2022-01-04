package co.com.sofka.domain.gestionEducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estudio implements ValueObject<String> {

    private final String estudio;

    public Estudio(String estudio) {
        this.estudio = Objects.requireNonNull(estudio, "El estudio es requerido");

        if (this.estudio.isBlank()){
            throw new IllegalArgumentException("El estudio no puede estar vacío");
        }

        if (this.estudio.length() <= 0 || this.estudio.length() >= 50){
            throw new IllegalArgumentException("El estudio no puede ser menor o igual a cero ni " +
                    "mayor a 50");
        }

    }

    @Override
    public String value() {
        return estudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudio estudio1 = (Estudio) o;
        return Objects.equals(estudio, estudio1.estudio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudio);
    }
}
