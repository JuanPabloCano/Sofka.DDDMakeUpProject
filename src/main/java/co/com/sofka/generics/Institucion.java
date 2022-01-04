package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Institucion implements ValueObject<String> {

    private final String nombre;

    public Institucion(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre es requerido");

        if (this.nombre.isBlank()){
            throw new IllegalArgumentException("El área no puede estar en vacía");
        }

        if (this.nombre.length() <= 0 || this.nombre.length() >= 100){
            throw new IllegalArgumentException("El nombre no puede ser menor o igual a cero ni mayor a 100");
        }

    }
    @Override
    public String value() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institucion that = (Institucion) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
