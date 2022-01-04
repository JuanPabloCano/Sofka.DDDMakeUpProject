package co.com.sofka.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ConocimientosAdquiridos implements ValueObject<String> {

    private final String conocimientosAdquiridos;

    public ConocimientosAdquiridos(String conocimientosAdquiridos) {
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos, "Los conocimientos adquiridos " +
                "son requeridos");

        if (this.conocimientosAdquiridos.isBlank()){
            throw new IllegalArgumentException("Los conocimientos adquiridos no pueden estar vacíos");
        }

        if (this.conocimientosAdquiridos.length() <= 0 || this.conocimientosAdquiridos.length() >= 150){
            throw new IllegalArgumentException("Los conocimientos adquiridos no pueden ser menor o igual a cero ni " +
                    "mayor a 150");
        }

    }
    @Override
    public String value() {
        return conocimientosAdquiridos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConocimientosAdquiridos that = (ConocimientosAdquiridos) o;
        return Objects.equals(conocimientosAdquiridos, that.conocimientosAdquiridos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conocimientosAdquiridos);
    }
}

