package co.com.sofka.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Area implements ValueObject<String> {

    private final String area;

    public Area(String area) {
        this.area = Objects.requireNonNull(area, "El área es requerida");

        if (this.area.isBlank()){
            throw new IllegalArgumentException("El área no puede estar en vacía");
        }

        if (this.area.length() <= 0 || this.area.length() >= 20){
            throw new IllegalArgumentException("El área no puede ser menor o igual a cero ni mayor a 20");
        }

    }

    @Override
    public String value() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area1 = (Area) o;
        return Objects.equals(area, area1.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area);
    }
}
