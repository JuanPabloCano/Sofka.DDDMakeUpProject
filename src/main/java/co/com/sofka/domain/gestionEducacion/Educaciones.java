package co.com.sofka.domain.gestionEducacion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.domain.gestionEducacion.values.Estudio;
import co.com.sofka.domain.gestionEducacion.values.Tipo;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class Educaciones extends Entity<EducacionesID> {

    protected EducacionesID educacionesID;
    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public Educaciones(EducacionesID educacionesID, Tipo tipo, Estudio estudio, Institucion institucion,
                       Periodo periodo) {
        super(educacionesID);
        this.tipo = Objects.requireNonNull(tipo);
        this.estudio = Objects.requireNonNull(estudio);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public void modificarTipo(Tipo tipo){
        this.tipo = Objects.requireNonNull(tipo);
    }

    public void modificarEstudio(Estudio estudio){
        this.estudio = Objects.requireNonNull(estudio);
    }

    public void modificarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void actualizarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public EducacionesID EducacionesID() {
        return educacionesID;
    }

    public Tipo Tipo() {
        return tipo;
    }

    public Estudio Estudio() {
        return estudio;
    }

    public Institucion Institucion() {
        return institucion;
    }

    public Periodo Periodo() {
        return periodo;
    }
}
