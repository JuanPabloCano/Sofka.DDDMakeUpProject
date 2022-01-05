package co.com.sofka.domain.gestionCertificacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.domainEvents.*;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.List;
import java.util.Objects;

public class GestionCertificacion extends AggregateEvent<GestionCertificacionID> {

    protected HojaDeVidaID hojaDeVidaID;
    protected Certificacion certificacion;

    private GestionCertificacion(GestionCertificacionID gestionCertificacionID) {
        super(gestionCertificacionID);
        subscribe(new GestionCertificacionChange(this));
    }

    public GestionCertificacion(GestionCertificacionID gestionCertificacionID, HojaDeVidaID hojaDeVidaID) {
        super(gestionCertificacionID);
        appendChange(new GestionCertificacionCreada(gestionCertificacionID, hojaDeVidaID)).apply();
    }

    public static GestionCertificacion from(GestionCertificacionID gestionCertificacionID, List<DomainEvent> events){
        var gestionCertificacion = new GestionCertificacion(gestionCertificacionID);
        events.forEach(gestionCertificacion::applyEvent);
        return gestionCertificacion;
    }

    public void agregarNuevaCertificacion(Nombre nombre, Institucion institucion, Periodo periodo){
        var id = new CertificacionID();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new NuevaCertificacionAgregada(id, nombre, institucion, periodo)).apply();
    }

    public void modificarNombreCertificacion(Nombre nombre){
        var id = new CertificacionID();
        Objects.requireNonNull(nombre);
        appendChange(new NombreCertificacionModificada(id, nombre)).apply();
    }

    public void modificarInstitucionCertificacion(Institucion institucion){
        var id = new CertificacionID();
        Objects.requireNonNull(institucion);
        appendChange(new InstitucionCertificacionModificada(id, institucion)).apply();
    }

    public void modificarPeriodoCertificacion(Periodo periodo){
        var id = new CertificacionID();
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoCertificacionModificado(id, periodo)).apply();
    }

    public HojaDeVidaID getHojaDeVidaID() {
        return hojaDeVidaID;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
