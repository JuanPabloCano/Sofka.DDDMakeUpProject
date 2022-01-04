package co.com.sofka.domain.gestionCertificacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String nombre;

    public Nombre(String nombre) {
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
        Nombre nombre1 = (Nombre) o;
        return Objects.equals(nombre, nombre1.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
