package co.com.sofka.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FotoDePerfil implements ValueObject<String> {

    private final String fotoDePerfil;

    public FotoDePerfil(String fotoDePerfil) {
        this.fotoDePerfil = Objects.requireNonNull(fotoDePerfil, "La foto de perfil es requerida");

        if (this.fotoDePerfil.isBlank()){
            throw new IllegalArgumentException("La foto de perfil no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return fotoDePerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoDePerfil that = (FotoDePerfil) o;
        return Objects.equals(fotoDePerfil, that.fotoDePerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fotoDePerfil);
    }
}
