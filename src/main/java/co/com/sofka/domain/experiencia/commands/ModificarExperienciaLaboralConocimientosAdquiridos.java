package co.com.sofka.domain.experiencia.commands;

import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class ModificarExperienciaLaboralConocimientosAdquiridos extends Command {

    private final ExperienciaID experienciaID;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public ModificarExperienciaLaboralConocimientosAdquiridos(ExperienciaID experienciaID, ConocimientosAdquiridos conocimientosAdquiridos) {
        this.experienciaID = Objects.requireNonNull(experienciaID);
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
