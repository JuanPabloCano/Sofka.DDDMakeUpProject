package co.com.sofka.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionDeContacto implements ValueObject<String> {

    private final String informacionDeContacto;

    public InformacionDeContacto(String informacionDeContacto) {
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto, "La información de contacto es " +
                "requerida");
        if (this.informacionDeContacto.isBlank()){
            throw new IllegalArgumentException("La información de contacto no puede estar vacía");
        }
        if (this.informacionDeContacto.length() <= 0 || this.informacionDeContacto.length() >= 200){
            throw new IllegalArgumentException("La información de contacto no puede ser menor o igual a cero ni mayor" +
                    " a 200");
        }

    }

    @Override
    public String value() {
        return informacionDeContacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformacionDeContacto that = (InformacionDeContacto) o;
        return Objects.equals(informacionDeContacto, that.informacionDeContacto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informacionDeContacto);
    }
}
