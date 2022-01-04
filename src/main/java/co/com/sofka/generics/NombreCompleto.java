package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<String> {

    private final String nombre;
    private final String apellido;

    public NombreCompleto(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre es requerido");
        this.apellido = Objects.requireNonNull(apellido, "El apellido es requerido");

        if (this.nombre.isBlank() || this.apellido.isBlank()){
            throw new IllegalArgumentException("El campo no puede estar vacío");
        }

        if (this.nombre.length() <= 0 || this.apellido.length() <= 0){
            throw new IllegalArgumentException("Los campos no pueden ser menores o iguales a cero");
        }

        if (this.nombre.length() >= 100 || this.apellido.length() >= 100){
            throw new IllegalArgumentException("Los campos no pueden ser mayores a 100");
        }


    }
    @Override
    public String value() {
        return nombre + " " + apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCompleto nombreCompleto = (NombreCompleto) o;
        return Objects.equals(nombre, nombreCompleto.nombre) && Objects.equals(apellido, nombreCompleto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
