package co.com.sofka.domain.gestionCertificacion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.Objects;

public class Certificacion extends Entity<CertificacionID> {

    protected CertificacionID certificacionID;
    protected Nombre nombre;
    protected Institucion institucion;
    protected Periodo periodo;

    public Certificacion(CertificacionID certificacionID, Nombre nombre, Institucion institucion, Periodo periodo) {
        super(certificacionID);
        this.nombre = Objects.requireNonNull(nombre);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public void modificarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void modificarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void modificarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public CertificacionID CertificacionID() {
        return certificacionID;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Institucion Institucion() {
        return institucion;
    }

    public Periodo Periodo() {
        return periodo;
    }
}
